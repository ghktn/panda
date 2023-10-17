package com.playdata.panda.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.playdata.panda.dto.CategorySub;
import com.playdata.panda.dto.PandaClass;
import com.playdata.panda.dto.Review;
import com.playdata.panda.service.ClassService;

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
    public String registerClass(PandaClass dto) {
    	classService.registerClass(dto);
    	System.out.println(dto);
    	return "redirect:/myclass-list";
    }
    @PostMapping("/register-review")
    public String registerReview(Review review){
    	classService.registerReview(review);
    	return "redirect:/myclass-list";
    	
    }
}
