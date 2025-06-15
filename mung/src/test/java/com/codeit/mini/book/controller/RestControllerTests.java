package com.codeit.mini.book.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.codeit.mini.entity.book.BookEntity;
import com.codeit.mini.entity.book.RentEntity;
import com.codeit.mini.repository.book.IBookRepository;
import com.codeit.mini.repository.book.IRentRepository;
import com.codeit.mini.repository.book.IWishRepository;
import com.codeit.mini.repository.member.IMemberRepository;
import com.codeit.mini.service.book.IBookSearchService;
import com.codeit.mini.service.book.IRentService;
import com.codeit.mini.service.book.IWishService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class RestControllerTests {
	
	@Autowired
	private IMemberRepository memberRepository;
	@Autowired
	private IBookRepository bookRepository;
	@Autowired
	private IBookSearchService searchService;
	@Autowired
	private IRentRepository rentRepository;
	@Autowired
	private IRentService rentService;
	@Autowired
	private IWishRepository wishRepository;
	@Autowired
	private IWishService wishService;
	
//	@Test
//	void testRsetSearchList() {
//		Pageable pageable = PageRequest.of(1, 20);
//		
//		Page<BookEntity> rs = searchService.searchBook("all", null, null, pageable);
//		
//		try {
//			if (!rs.isEmpty()) {
//				for (BookEntity bookEntity : rs) {
//					log.info("검색 결과 : {}", bookEntity);
//				}
//			} else {
//				log.info("검색 결과가 없습니다.");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	void testRent() throws Exception {
//		
//		Long bookId = 1L;
//		Long memberId = 1L;
//		
//		if (!bookRepository.existsById(bookId)) {
//			log.error("Book No");
//		}
//		if (!memberRepository.existsById(memberId)) {
//			log.error("Member No");
//		}
//		
//		RentEntity rentEntity = rentService.rentBook(bookId, memberId);
//		
//		log.info("대여 결과 : {}", rentEntity);
//	}
	
}
