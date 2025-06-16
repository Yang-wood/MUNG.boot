package com.codeit.mini.service.book.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeit.mini.dto.book.ReviewDTO;
import com.codeit.mini.entity.book.BookEntity;
import com.codeit.mini.entity.book.RentEntity;
import com.codeit.mini.entity.book.ReviewEntity;
import com.codeit.mini.entity.member.MemberEntity;
import com.codeit.mini.repository.book.IBookRepository;
import com.codeit.mini.repository.book.IRentRepository;
import com.codeit.mini.repository.book.IReviewRepository;
import com.codeit.mini.repository.member.IMemberRepository;
import com.codeit.mini.service.book.IReviewService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReviewServiceImpl implements IReviewService{
	
	private final IReviewRepository reviewRepository;
	private final IRentRepository rentRepository;
	private final IBookRepository bookRepository;
	
	private void updateAvgRating(Long bookId) {
		try {
			Double avgRating = reviewRepository.findAvgRatingReviewByBookId(bookId);
			
			BookEntity bookEntity = bookRepository.findById(bookId)
					.orElseThrow(() -> new IllegalAccessException("NOT BOOK"));
			bookEntity.setAvgRating(avgRating);
			bookRepository.save(bookEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	@Transactional
	public ReviewEntity regReview(ReviewDTO reviewDTO) throws Exception {
		
		RentEntity rent = rentRepository.findById(reviewDTO.getRentId())
				.orElseThrow(() -> new IllegalAccessException("Not RentId"));
		
		if (rent.getHasReview() != null && rent.getHasReview() == 1) {
			throw new IllegalStateException("이미 리뷰가 있습니다.");
		}
		
		ReviewEntity reviewEntity = dtoToEntity(reviewDTO);
		
		ReviewEntity saveReview = reviewRepository.save(reviewEntity);
		
		rent.setHasReview(1);
		rentRepository.save(rent);
		
		updateAvgRating(reviewDTO.getBookId());
		
		return saveReview;
	}

	@Override
	@Transactional
	public void removeReview(Long reviewId) throws Exception {
		
		ReviewEntity review = reviewRepository.findById(reviewId)
				.orElseThrow(() -> new IllegalAccessException("Not ReviewId"));
				
		RentEntity rent = review.getRentEntity();
		if (rent == null) {
			throw new IllegalStateException("Not Rent");
		}
		
		Long bookIdUpdate = review.getBookEntity().getBookId();
		
		reviewRepository.delete(review);
		
		rent.setHasReview(0);
		rentRepository.save(rent);
		
		updateAvgRating(bookIdUpdate);
		
	}

	@Override
	@Transactional
	public void modifyReview(ReviewDTO reviewDTO) throws Exception {
		
		ReviewEntity review = reviewRepository.findById(reviewDTO.getReviewId())
				.orElseThrow(() -> new IllegalAccessException("NOT REVIEW"));
		
		review.setTitle(reviewDTO.getTitle());
		review.setContent(reviewDTO.getContent());
		review.setRating(reviewDTO.getRating());
		
		reviewRepository.save(review);
		
		updateAvgRating(review.getBookEntity().getBookId());
	}

	@Override
	public Page<ReviewEntity> findReviewByBookId(Long bookId, Pageable pageable) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReviewEntity> findReviewByMemberId(Long bookId, Long MemberId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
