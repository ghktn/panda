package com.playdata.panda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.playdata.panda.dto.Application;
import com.playdata.panda.dto.LoginSuccessDTO;
import com.playdata.panda.service.ApplicationService;
import com.playdata.panda.util.SessionConst;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ApplicationApiController {
	
	private final ApplicationService applicationService;
	
	@PostMapping("/application")
	public String application(@SessionAttribute(value = SessionConst.LOGIN_MEMBER) LoginSuccessDTO user, Application application) {
		System.out.println("================="+application);
		applicationService.application(application,user.getId());
		
		System.out.println(application);
		return "redirect:/myapply-list";
	}
}