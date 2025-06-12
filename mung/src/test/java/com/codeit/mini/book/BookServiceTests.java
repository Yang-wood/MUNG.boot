package com.codeit.mini.book;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codeit.mini.dto.book.BookDTO;
import com.codeit.mini.dto.book.UpdateBookDTO;
import com.codeit.mini.entity.book.BookEntity;
import com.codeit.mini.repository.book.IBookRepository;
import com.codeit.mini.service.book.IBookService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class BookServiceTests {

	@Autowired
	private IBookService service;
	
	@Autowired
	private IBookRepository repository;
	
//	@Test
//	void testUpdateBook() throws Exception{
//		UpdateBookDTO updateBookDTO = UpdateBookDTO.builder().bookId(6L).category("전쟁")
//				.description("수정해본다").rentPoint(200).build();
//		
//		service.modify(updateBookDTO);
//		
//		BookEntity rs = repository.findById(6L).orElseThrow();
//		log.info("업뎃 결과 : {}", rs);
//		
//	}
	
//	@Test
//	void testRemoveBook() throws Exception {
//		Long bookId = 6L;
//		
//		service.remove(bookId);
//	}
	
//	@Test
//	void testGetById() throws Exception {
//		Long bookId = 7L;
//		
//		BookDTO bookDTO = service.getBookById(bookId);
//		
//		log.info(bookDTO);
//	}
	
//	@Test
//	void testBookList() throws Exception {
//		List<BookDTO> bookDTOList = service.getAllBooks();
//		
//		bookDTOList.forEach(book -> {
//			log.info("info : {}", book);
//		});
//	}

}
