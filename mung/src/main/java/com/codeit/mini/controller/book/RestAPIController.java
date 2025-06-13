package com.codeit.mini.controller.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeit.mini.dto.book.BookDTO;
import com.codeit.mini.entity.book.BookEntity;
import com.codeit.mini.entity.book.RentEntity;
import com.codeit.mini.entity.book.WishEntity;
import com.codeit.mini.service.book.IBookSearchService;
import com.codeit.mini.service.book.IBookService;
import com.codeit.mini.service.book.IRentService;
import com.codeit.mini.service.book.IWishService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
@Log4j2
public class RestAPIController {
	
	private final IBookSearchService searchService;
	private final IBookService bookService;
	private final IRentService rentService;
	private final IWishService wishService;
	
	// 도서 검색
	@GetMapping("/search")
	public ResponseEntity<Page<BookDTO>> searchBook(@RequestParam String keyword,
            										@RequestParam String type,
            										@RequestParam Integer point,
            										Pageable pageable) {
		
		Page<BookEntity> searchList = searchService.searchBook(type, keyword, point, pageable);
		
		Page<BookDTO> dtoPage = searchList.map(bookService::entityToDto);
		
		return new ResponseEntity<>(dtoPage, HttpStatus.OK);
	}
	
	
	// 도서 대여
	@PostMapping("/rent")
	public ResponseEntity<RentEntity> rentBook(@RequestParam Long bookId,
									  @RequestParam Long memberId) {
		try {
			RentEntity rentEntity = rentService.rentBook(bookId, memberId);
			return new ResponseEntity<>(rentEntity, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	// 도서 찜
	@PostMapping("/toggle")
	public ResponseEntity<String> toggleWish(@RequestParam Long bookId,
												 @RequestParam Long memberId) {
		try {
			boolean isWish = wishService.toggleWish(memberId, bookId);
			
			return new ResponseEntity<>(isWish ? "찜 추가" : "찜 삭제", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
