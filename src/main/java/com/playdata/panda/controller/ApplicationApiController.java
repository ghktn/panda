package com.playdata.panda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.playdata.panda.dto.Application;
import com.playdata.panda.service.ApplicationService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ApplicationApiController {
	
	private final ApplicationService applicationService;
	@PostMapping("/application")
	public String application(Application application) {
		applicationService.application(application);
		
		System.out.println(application);
		return "redirect:/";
	}
}
