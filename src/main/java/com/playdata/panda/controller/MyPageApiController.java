package com.playdata.panda.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.playdata.panda.dto.CategorySub;
import com.playdata.panda.dto.LoginSuccessDTO;
import com.playdata.panda.dto.PandaClass;
import com.playdata.panda.dto.RecruitmentBoard;
import com.playdata.panda.dto.Review;
import com.playdata.panda.service.ClassService;
import com.playdata.panda.util.SessionConst;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyPageApiController {
    private final ClassService classService;

    @GetMapping("/category-sub")
    @ResponseBody
    public List<CategorySub> findCategorySubList(int category_main_id){
        List<CategorySub> categorySubList = classService.findCategorySubList(category_main_id);
        return categorySubList;
    }
    @PostMapping("/register-class")
    @ResponseBody
    public ResponseEntity<Integer> registerClass(@SessionAttribute(value=SessionConst.LOGIN_MEMBER) LoginSuccessDTO user,@RequestBody PandaClass dto) {
    	int result= classService.registerClass((int)user.getId(),dto);
    	return ResponseEntity.ok()
				.body(result);
    }
    @PostMapping("/review")
	@ResponseBody
	public ResponseEntity<Integer> save(@RequestBody Review review) {
		
		int result = classService.save(review);
		
		return ResponseEntity.ok()
				.body(result);
	}
}
