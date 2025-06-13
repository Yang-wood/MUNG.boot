package com.codeit.mini.book.service;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codeit.mini.entity.book.BookEntity;
import com.codeit.mini.entity.book.RentEntity;
import com.codeit.mini.entity.member.MemberEntity;
import com.codeit.mini.repository.book.IBookRepository;
import com.codeit.mini.repository.book.IRentRepository;
import com.codeit.mini.repository.member.IMemberRepository;
import com.codeit.mini.service.book.IRentService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class RentServiseTests {

	@Autowired
	private IRentService rentService;
	
	@Autowired
	private IRentRepository rentRepository;
	
	@Autowired
	private IMemberRepository memberRepository;
	
	@Autowired
	private IBookRepository bookRepository;
	
//	@Test
//	void testRegRent() throws Exception {
//		
//		Long memberId = 1L;
//		Long bookId = 1L;
//		
//		rentService.rentBook(bookId, memberId);
//		
//	}
	
	// 자동 반납 구현 테스트
//	@Test
//	void testRentEnd() throws Exception {
//		
//		Long memberId = 4L;
//		Long bookId = 4L;
//		
//		MemberEntity memberEntity = memberRepository.findById(memberId).orElseThrow();
//		BookEntity bookEntity = bookRepository.findById(bookId).orElseThrow();
//		
//		LocalDateTime expireDate = LocalDateTime.now().minusDays(10);
//		LocalDateTime returnDate = expireDate.plusDays(7);
//		
//		RentEntity rentEntity = RentEntity.builder().memberEntity(memberEntity)
//													.bookEntity(bookEntity)
//													.rentDate(returnDate)
//													.returnDate(returnDate)
//													.isReturned(0)
//													.readPage(0)
//        											.readState(0)
//        											.hasReview(0)
//													.hasPoint(0)
//													.build();
//		
//		rentRepository.save(rentEntity);
//		
//		rentService.rentEndList();
//		
//		RentEntity result = rentRepository.findById(rentEntity.getRentId()).orElseThrow();
//		
//		
//		log.info("만료 처리된 ID : {}", result.getRentId());
//	}

}
