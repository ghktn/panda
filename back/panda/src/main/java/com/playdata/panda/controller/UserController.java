package com.playdata.panda.controller;

import com.playdata.panda.domain.User;
import com.playdata.panda.dto.SignUpRegisterDTO;
import com.playdata.panda.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    /**
     * @return 회원가입 페이지 화면을 리턴한다.
     */
    @GetMapping("/signup")
    public String signupPageView() {
        return "member/register";
    }

    @PostMapping("/signup")
    public String signUp(SignUpRegisterDTO signUpRegisterDTO) {

        System.out.println(signUpRegisterDTO);
        userService.signUp(signUpRegisterDTO);

        return "redirect:/";
    }

}
