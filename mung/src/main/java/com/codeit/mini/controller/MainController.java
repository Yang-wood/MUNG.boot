package com.codeit.mini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/main")
	public String maingpage() {
		return "main";
	}
	
	@GetMapping("/codeit")
	public String codeit(Model model) {
		
		model.addAttribute("currentUri", "/codeit");
		
		return "codeit";
	}
}
