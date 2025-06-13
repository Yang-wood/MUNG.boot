package com.codeit.mini.service.book.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeit.mini.entity.book.BookEntity;
import com.codeit.mini.entity.book.WishEntity;
import com.codeit.mini.entity.member.MemberEntity;
import com.codeit.mini.repository.book.IBookRepository;
import com.codeit.mini.repository.book.IWishRepository;
import com.codeit.mini.repository.member.IMemberRepository;
import com.codeit.mini.service.book.IWishService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WishServiceImpl implements IWishService{
	
	private final IWishRepository wishRepository;
	private final IMemberRepository memberRepository;
	private final IBookRepository bookRepository;
	
	@Transactional
	@Override
	public boolean toggleWish(Long memberId, Long bookId) throws Exception {
		
		MemberEntity memberEntity = memberRepository.findById(memberId)
								.orElseThrow(() -> new IllegalAccessException("NOT Member"));
		BookEntity bookEntity = bookRepository.findById(bookId)
								.orElseThrow(() -> new IllegalAccessException("NOT Book"));
		
		Optional<WishEntity> existWish = wishRepository.findByMemberEntityAndBookEntity(memberEntity, bookEntity);
		
		if (existWish.isPresent()) {
			// 찜 횟수 감소식
			bookEntity.setWishCount(bookEntity.getWishCount() - 1);
			bookRepository.save(bookEntity);
			wishRepository.delete(existWish.get());
			return false;
		} else {
			WishEntity wishEntity = WishEntity.builder().memberEntity(memberEntity)
														.bookEntity(bookEntity)
														.build();
			// 찜 횟수 증가식
			bookEntity.setWishCount(bookEntity.getWishCount() + 1);
			bookRepository.save(bookEntity);
			wishRepository.save(wishEntity);
			return true;
		}
	}

}
