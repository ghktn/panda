package com.playdata.panda.controller;

import com.playdata.panda.dto.CategorySub;
import com.playdata.panda.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyPageApiController {
    private final ClassService classService;

    @GetMapping("/category-sub")
    @ResponseBody
    public List<CategorySub> findCategorySubList(int category_main_id){
        System.out.println(category_main_id);
        List<CategorySub> categorySubList = classService.findCategorySubList(category_main_id);
        return categorySubList;
    }
}
