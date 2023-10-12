package com.playdata.panda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeViewController {
	@GetMapping("/notice")
	 public String moveNoticePageView() {
        return "notice/notice";
    }
}
