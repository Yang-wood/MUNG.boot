package com.codeit.mini.book.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.codeit.mini.entity.book.ReviewEntity;
import com.codeit.mini.repository.book.IBookRepository;
import com.codeit.mini.repository.book.IRentRepository;
import com.codeit.mini.repository.book.IReviewRepository;
import com.codeit.mini.repository.member.IMemberRepository;
import com.codeit.mini.service.book.IReviewService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class ReviewServiceTests {
	
	@Autowired
	private IReviewService reviewService;
	
	@Autowired
	private IReviewRepository reviewRepository;
	
	@Autowired
	private IBookRepository bookRepository;
	
	@Autowired
	private IMemberRepository memberRepository;
	
	@Autowired
	private IRentRepository rentRepository;
	
	
//	@Test
//	void testReg() throws Exception {
//		
//		Long rentId = 10L;
//		Long memberId = 2L;
//		Long bookId = 15L;
//		int rating = 5;
//		
//		
//		RentEntity rentEntity = rentRepository.findById(rentId)
//								.orElseThrow(() -> new IllegalAccessException("NOT RENT"));
//		if (rentEntity.getHasReview() == 1) {
//			throw new IllegalStateException("HAS_REVIEW");
//		}
//		
//		ReviewDTO reviewDTO = ReviewDTO.builder().rentId(rentId)
//												 .memberId(memberId)
//												 .bookId(bookId)
//												 .title("추천")
//												 .content("완벽합니당")
//												 .rating(rating)
//												 .build();
//		
//		ReviewEntity rs = reviewService.regReview(reviewDTO);
//		
//		assertNotNull(rs);
//		assertEquals(reviewDTO.getRating(), rs.getRating());
//		assertEquals(1, rentRepository.findById(rentId).get().getHasReview());
//		
// 	}
	
//	@Test
//	void testRemove() throws Exception {
//		Long reviewId = 1L;
//		
//		reviewService.removeReview(reviewId);
//		
//		assertFalse(reviewRepository.findById(reviewId).isPresent(), "No remove");
//		
//	}
	
//	@Test
//	void testModify() throws Exception {
//		Long reviewId = 2L;
//		
//		ReviewEntity reviewEntity = reviewRepository.findById(reviewId)
//				.orElseThrow(() -> new IllegalAccessException("NOT REVIEW"));
//		
//		ReviewDTO reviewDTO = ReviewDTO.builder().reviewId(reviewId)
//												 .title("제목 수정")
//												 .content("내용 수정")
//												 .rating(1)
//												 .build();
//		
//		reviewService.modifyReview(reviewDTO);
//		
//	}
	
//	@Test
//	void testPageBookAllReview() throws Exception {
//		
//		Long bookId = 13L;
//		
//		Pageable pageable = PageRequest.of(0, 10, Sort.by("regDate").descending());
//		
//		Page<ReviewEntity> page = reviewService.findReviewByBookId(bookId, pageable);
//		
//		assertNotNull(page);
//		
//		for (ReviewEntity reviewEntity : page.getContent()) {
//			log.info("===========================================");
//			log.info("제목 : {}", reviewEntity.getTitle());
//			log.info("내용 : {}", reviewEntity.getContent());
//			log.info("별점 : {}", reviewEntity.getRating());
//		}
//	}
	
//	@Test
//	void testListMemberAllReview() throws Exception {
//		Long bookId = 13L;
//		Long memberId = 24L;
//		
//		List<ReviewEntity> reviewList = reviewService.findReviewByMemberId(bookId, memberId);
//		
//		assertNotNull(reviewList);
//		
//		for (ReviewEntity reviewEntity : reviewList) {
//			log.info("============================================");
//			log.info("제목 : {}", reviewEntity.getTitle());
//			log.info("내용 : {}", reviewEntity.getContent());
//			log.info("별점 : {}", reviewEntity.getRating());
//		}
//	}
	
}
