package com.codeit.mini.book.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codeit.mini.repository.book.IBookRepository;
import com.codeit.mini.repository.book.IWishRepository;
import com.codeit.mini.repository.member.IMemberRepository;
import com.codeit.mini.service.book.IWishService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class WishServiceTests {
	
	@Autowired
	private IWishService wishService;
	
	@Autowired
	private IMemberRepository memberRepository;
	
	@Autowired
	private IBookRepository bookRepository;
	
	@Autowired
	private IWishRepository wishRepository;
	
	@Test
	void testToggleWish() throws Exception {
		Long memberId = 1L;
		Long bookId = 1L;
		
		//boolean added = wishService.toggleWish(memberId, bookId);
		
		boolean remove = wishService.toggleWish(memberId, bookId);
				
		
	}
}
