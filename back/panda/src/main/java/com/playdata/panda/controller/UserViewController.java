package com.playdata.panda.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.playdata.panda.dto.RegionSd;
import com.playdata.panda.service.RegionService;
import com.playdata.panda.service.UserService;
import com.playdata.panda.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserViewController {

	private final UserService userService;
	private final RegionService regionService;

	/**
	 * @return 회원가입 페이지 화면을 리턴한다.
	 */
	@GetMapping("/signup")
	public String signupPageView(Model model) {
		List<RegionSd> regionSdList = regionService.findRegionSdList();
		model.addAttribute("regionSdList", regionSdList);
		return "member/register";
	}

	@GetMapping("/login")
	public String loginPageView() {
		return "member/login2";
	}

	@GetMapping("/mypage")
	public String myPageView() {
		return "member/my-page";
	}

}
