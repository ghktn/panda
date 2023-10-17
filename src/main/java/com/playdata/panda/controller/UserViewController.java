package com.playdata.panda.controller;

import com.playdata.panda.dto.RegionSd;
import com.playdata.panda.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

<<<<<<< HEAD
import java.util.List;
=======
import com.playdata.panda.dto.User;
import com.playdata.panda.service.UserService;
>>>>>>> feature/profile

@Controller
@RequiredArgsConstructor
public class UserViewController {

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
