package com.codeit.mini.book;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codeit.mini.entity.book.BookEntity;
import com.codeit.mini.service.book.IBookSearchService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class BookSearchServiceTests {
	
	@Autowired
	private IBookSearchService bookSearchService;
	
	@Test
	void testSearch() {
		
		String type = "all";
		String keyword = "";
		
		List<BookEntity> rs = bookSearchService.searchBook(type, keyword);
		
		rs.forEach(book -> {
			log.info(book);
		});
		
		boolean containsKeyword = rs.stream().allMatch(book ->
	        (book.getTitle() != null && book.getTitle().toLowerCase().contains(keyword.toLowerCase())) ||
	        (book.getAuthor() != null && book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) ||
	        (book.getCategory() != null && book.getCategory().toLowerCase().contains(keyword.toLowerCase()))
		);
		assertTrue(containsKeyword, "모든 도서가 키워드를 포함해야 합니다.");
	}

}
