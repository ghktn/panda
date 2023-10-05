package com.playdata.panda.controller;

import com.playdata.panda.dto.SignUpRegisterDTO;
import com.playdata.panda.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserApiController {

    private final UserService userService;

    /**
     * @return 회원가입 후, 메인페이지를 리턴한다.
     */
    @PostMapping("/signup")
    public String signUp(SignUpRegisterDTO signUpRegisterDTO) {

        System.out.println(signUpRegisterDTO);
        userService.signUp(signUpRegisterDTO);

        return "redirect:/";
    }

}
