package com.playdata.panda.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playdata.panda.dto.RecruitmentBoardPandaClassDTO;
import com.playdata.panda.service.RecruitmentBoardService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/recruitment")
@RequiredArgsConstructor
@Controller
public class RecruitmentViewController {
	
	private final RecruitmentBoardService recruitmentBoardService;
	
	/**
	 * 기능 : 글쓰기로 이동합니다.
	 */
	@GetMapping("/write")
	public String getRecruitmentWrite() {
		
		return "/recruitment/recruitment-board-write";
	}
	
	/**
	 * 기능 : 리스트 페이지로 이동합니다.
	 */
	@GetMapping
	public String getSelectAll(Model model) {
		
		List<RecruitmentBoardPandaClassDTO> boardList = recruitmentBoardService.selectAll();
		
		model.addAttribute("boardList", boardList);
		return "recruitment/recruitment-board";
	}
	
	/**
	 * 기능 : 상세보기로 이동합니다.
	 */
	@GetMapping("/detail/{id}")
	public String getRecruitmentDetail(@PathVariable int id, Model model) {
		
		// 정보 불러오기
		RecruitmentBoardPandaClassDTO board = recruitmentBoardService.selectOne(id);
		model.addAttribute("board", board);
		
		return "recruitment/recruitment-detail";
	}
}
