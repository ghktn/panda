package com.playdata.panda.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.playdata.panda.service.ApplicationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ApplicationViewController {
	
	private final ApplicationService applicationService;
	
	@GetMapping("/recruitment-detail")
	public String applicationViewPage() {
		return "recruitment/recruitment-detail";
	}
	
}
