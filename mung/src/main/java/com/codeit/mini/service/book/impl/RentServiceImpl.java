package com.codeit.mini.service.book.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeit.mini.entity.book.BookEntity;
import com.codeit.mini.entity.book.RentEntity;
import com.codeit.mini.entity.member.MemberEntity;
import com.codeit.mini.repository.book.IBookRepository;
import com.codeit.mini.repository.book.IRentRepository;
import com.codeit.mini.repository.member.IMemberRepository;
import com.codeit.mini.service.book.IRentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class RentServiceImpl implements IRentService {
	
	private final IRentRepository rentRepository;
	private final IMemberRepository memberRepository;
	private final IBookRepository bookRepository;
	
	// 대여 등록
	@Override
	@Transactional
	public RentEntity rentBook(Long bookId, Long memberId) throws Exception {
		MemberEntity memberEntity = memberRepository.findById(memberId)
							  .orElseThrow(() -> new IllegalAccessException("memInfo : No"));
		BookEntity bookEntity = bookRepository.findById(bookId)
							  .orElseThrow(() -> new IllegalAccessException("bookInfo : No"));
		
		LocalDateTime now = LocalDateTime.now();
        LocalDateTime returnDate = now.plusDays(7);
        
        RentEntity rentEntity = RentEntity.builder().bookEntity(bookEntity)
        											.memberEntity(memberEntity)
        											.rentDate(now)
        											.returnDate(returnDate)
        											.isReturned(0)
        											.readPage(0)
        											.readState(0)
        											.hasReview(0)
        											.hasPoint(0)
        											.build();
        // 대여 횟수 증감식
		bookEntity.setRentCount(bookEntity.getRentCount() + 1);
		log.info("rentInfo : {}",rentEntity);
		rentRepository.save(rentEntity);
        
        return rentEntity;
	}
	
	// 자동 반납
	@Override
	@Transactional
	@Scheduled(cron = "0 0 12 * * ?")
	public void rentEndList() throws Exception {
		LocalDateTime now = LocalDateTime.now();
		
		List<RentEntity> expiredRent = rentRepository.findByIsReturnedAndReturnDateLessThanEqual(0, now);
	
		for (RentEntity rentEntity : expiredRent) {
			rentEntity.setIsReturned(1);
			rentRepository.save(rentEntity);
			log.info("반납처리 rentId : {}", rentEntity.getRentId());
		}
	}

}
