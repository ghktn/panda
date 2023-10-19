package com.playdata.panda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.playdata.panda.dto.ApplicationList;
import com.playdata.panda.service.ApplicationService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ApplicationViewController {
	private final ApplicationService applicationService;
	@GetMapping("/recruitment-detail")
	public String applicationViewPage() {
		return "recruitment/recruitment-detail";
	}
	@GetMapping("/accept-apply")
	public String acceptApply(String application_id,String class_id) {
		applicationService.acceptApply(application_id,class_id);
		return "redirect:/myapply-list";
	}
	@GetMapping("/reject-apply")
	public String rejectApply(String application_id,String cmd) {
		applicationService.rejectApply(application_id);
		return "redirect:/myapply-list";
	}
}
