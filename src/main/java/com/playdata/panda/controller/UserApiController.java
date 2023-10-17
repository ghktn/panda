package com.playdata.panda.controller;

import com.playdata.panda.dto.LoginDTO;
import com.playdata.panda.dto.LoginSuccessDTO;
import com.playdata.panda.dto.SignUpRegisterDTO;
import com.playdata.panda.service.UserService;
import com.playdata.panda.util.SessionConst;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;


@RequiredArgsConstructor
@Controller
public class UserApiController {

    private final UserService userService;

    /**
     * @return 회원가입 후, 메인페이지를 리턴한다.
     */
    @PostMapping("/signup")
    public String signUp(SignUpRegisterDTO signUpRegisterDTO) throws ParseException {

        System.out.println(signUpRegisterDTO);
        userService.signUp(signUpRegisterDTO);

        return "redirect:/";
    }


    /**
     * 기능 : 회원가입을 요청한다.
     */
    @PostMapping("/login")
    public String signIn(@RequestParam(defaultValue = "/") String returnUrl, LoginDTO userDto, HttpServletRequest request) {
        // 회원존재 여부를 확인한다.
        LoginSuccessDTO loginMember = userService.login(userDto);
        System.out.println(returnUrl);
        // 로그인 실패했을 때
        if (loginMember == null) {
            String requestUriQuery = request.getRequestURI();
            int queryStart = requestUriQuery.lastIndexOf("?returnUrl=");
            if (queryStart != -1) {
                returnUrl = requestUriQuery.substring(queryStart + 1);
            }
            return "redirect:/login?returnUrl=" + returnUrl;
        }
        // 성공하면 session에 userId, id 넘겨주기
        HttpSession session = request.getSession(true);
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        return "redirect:" + returnUrl;
    }

}
