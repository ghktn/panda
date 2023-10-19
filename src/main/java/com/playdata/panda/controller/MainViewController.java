package com.playdata.panda.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.playdata.panda.dto.MainDTO;
import com.playdata.panda.service.MainService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainViewController {

	private final MainService mainService;
	
	@GetMapping("/")
	public String selectMain(Model model) {
		List<MainDTO> MainDTO = mainService.selectMain();
		System.out.println(MainDTO);
		model.addAttribute("MainDTO", MainDTO);
		return "index";
	}
}
