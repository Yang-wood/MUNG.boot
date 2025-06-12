package com.codeit.mini.book;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codeit.mini.entity.book.BookEntity;
import com.codeit.mini.service.book.IBookSearchService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class RestControllerTests {
	
	@Autowired
	private IBookSearchService searchService;
	
	@Test
	void testRsetSearchList() {
		
		List<BookEntity> rs = searchService.searchBook("all", "");
		
		for (BookEntity bookEntity : rs) {
			log.info(bookEntity);
		}
	}

}
