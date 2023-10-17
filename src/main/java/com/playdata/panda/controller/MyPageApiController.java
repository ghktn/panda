package com.playdata.panda.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.playdata.panda.dto.CategorySub;
import com.playdata.panda.dto.PandaClass;
import com.playdata.panda.dto.User;
import com.playdata.panda.service.ClassService;
import com.playdata.panda.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyPageApiController {
    private final ClassService classService;
    private final UserService userService;

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
    
    //회원정보수정 - post
    @PostMapping("/myinfo-update")
    public String updateMyInfo(User user) {
    	System.out.println(user);
    	userService.updateMyInfo(user);
    	return "redirect:/mypage";
    }

}
