package com.playdata.panda.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.playdata.panda.dto.CategoryMain;
import com.playdata.panda.dto.CategorySub;
import com.playdata.panda.service.ClassService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TeacherChangeApiController {
	private final ClassService classService;
	
	@GetMapping("/cate-main")
    @ResponseBody
    public List<CategoryMain> findCategoryMainList(){
        List<CategoryMain> categoryMainList = classService.findCategoryMainList();
        return categoryMainList;
    }
	
    @GetMapping("/cate-sub")
    @ResponseBody
    public List<CategorySub> findCategorySubList(int category_main_id){
        List<CategorySub> categorySubList = classService.findCategorySubList(category_main_id);
        return categorySubList;
    }
}
