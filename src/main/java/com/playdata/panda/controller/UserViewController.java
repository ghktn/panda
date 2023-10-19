package com.playdata.panda.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.playdata.panda.dto.LoginSuccessDTO;
import com.playdata.panda.dto.RegionSd;
import com.playdata.panda.dto.User;
import com.playdata.panda.service.RegionService;
import com.playdata.panda.service.UserService;
import com.playdata.panda.util.SessionConst;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class UserViewController {

    private final RegionService regionService;
    private final UserService userService;

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
    public String myPageView(@SessionAttribute(value=SessionConst.LOGIN_MEMBER) LoginSuccessDTO user){
    	//유저 정보 불러오기
//    	User user = userService.selectMyInfo();
    	//수정한 세션 유저 정보 변경 
//    	session.setAttribute(SessionConst.LOGIN_MEMBER, user);
        return "member/my-page";
    }
    
    

}
