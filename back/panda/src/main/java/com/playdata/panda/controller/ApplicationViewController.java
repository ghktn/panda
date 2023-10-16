package com.playdata.panda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationViewController {
	
	@GetMapping("/recruitment-detail")
	public String applicationViewPage() {
		return "recruitment/recruitment-detail";
	}
}
