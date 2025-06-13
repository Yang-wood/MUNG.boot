package com.codeit.mini.controller.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codeit.mini.dto.book.BookDTO;
import com.codeit.mini.repository.book.IBookRepository;
import com.codeit.mini.service.book.IBookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class PageMoveController {
	
	private final IBookService bookService;
	
	@GetMapping("/")
	public String mainPage() {
		
		return "book/main";
	}
	
	@GetMapping("/search")
	public String searchPage(@RequestParam(value = "keyword", required = false) String keyword,
							 @RequestParam(value = "type", defaultValue = "all") String type,
							 @RequestParam(value = "point", required = false) Integer point,
							 Model model) {
		try {
			model.addAttribute("keyword", keyword);
			model.addAttribute("type", type);
			model.addAttribute("point", point);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "book/searchResult";
	}
	
	@GetMapping("/{bookId}")
	public String readPage(@PathVariable Long bookId, Model model) {
		try {
			
			BookDTO bookDTO = bookService.getBookById(bookId);
			
			if (bookDTO != null) {
				model.addAttribute("bookDTO", bookDTO);
			} else {
				return "error/404";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "book/read";
	}
	
	@GetMapping("/subList")
	public String subListPage() {
		return "book/subList";
	}
	
	@GetMapping("/myBook")
	public String myBookPage() {
		return "book/myBook";
	}
	
	@GetMapping
	public String adminPage() {
		return "book/admin";
	}
	
	
}
