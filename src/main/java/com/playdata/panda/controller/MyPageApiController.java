package com.playdata.panda.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.playdata.panda.dto.CategorySub;
import com.playdata.panda.dto.LoginDTO;
import com.playdata.panda.dto.LoginSuccessDTO;
import com.playdata.panda.dto.PandaClass;
import com.playdata.panda.dto.Review;
import com.playdata.panda.dto.User;
import com.playdata.panda.service.ClassService;
import com.playdata.panda.service.UserService;
import com.playdata.panda.util.SessionConst;

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
    @ResponseBody
    public ResponseEntity<Integer> registerClass(@RequestBody PandaClass dto) {
    	int result= classService.registerClass(dto);
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

    //회원정보수정 - post
    @PostMapping("/myinfo-update")
    public String updateMyInfo(@SessionAttribute(value=SessionConst.LOGIN_MEMBER) LoginSuccessDTO user, User users,HttpSession session) {
    	System.out.println(user);
    	//유저 데이터 수정하기
    	userService.updateMyInfo(users);
    	//유저 정보를 수정한 후에 세션에 저장된 유저객체를 변경
    	//1. xml에 sql정의
    	//  => user의 id 로 조회하는 기능한 구현
    	//2. 서비스, repository에 메소드 추가
    	LoginSuccessDTO updateuser = userService.findByUserId(users);
    	System.out.println("===============================================================");
    	System.out.println(updateuser);
    	session.setAttribute(SessionConst.LOGIN_MEMBER, updateuser);
    	//3. 업데이트 후에 디비에서 변경된 내용을 다시 조회해서
    	//4. 세션에 저장된 user객체 변경 - 다시 저장
    	return "redirect:/mypage";
    }

}
