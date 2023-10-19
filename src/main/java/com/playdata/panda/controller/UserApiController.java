package com.playdata.panda.controller;

import com.playdata.panda.dto.LoginDTO;
import com.playdata.panda.dto.LoginSuccessDTO;
import com.playdata.panda.dto.SignUpRegisterDTO;
import com.playdata.panda.dto.User;
import com.playdata.panda.service.UserService;
import com.playdata.panda.util.SessionConst;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

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
     * 기능 : 로그인을 한다.
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
    
   

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
    
    /**
     * 기능 : 세션 유저정보를 받아올 수 있습니다.
     */
    @ResponseBody
    @GetMapping("/users/info")
    public ResponseEntity<LoginSuccessDTO> getSuccessuserInfo(@SessionAttribute(value = SessionConst.LOGIN_MEMBER) LoginSuccessDTO user) {
    	
    	return ResponseEntity.ok()
    			.body(user);
    }
    
    /**
     * 기능 : 회원의 유저 구분 아이디를 '선생님'으로 변경할 수 있습니다.
     */
    @ResponseBody
    @PostMapping("/users/divisionid/teacher")
    public ResponseEntity<?> changeUserDivisionIdForTeacher(@SessionAttribute(value = SessionConst.LOGIN_MEMBER) LoginSuccessDTO user, HttpSession session) {
    	
    	String userDivisionId = "T";
    	userService.updateUserDivisionId(user.getId(), userDivisionId);
    	// 유저 정보 불러오기
		User userInfo = userService.findByIdV2(user.getId());
		LoginSuccessDTO loginUser = LoginSuccessDTO.create(userInfo.getId(), userInfo.getUser_id(), userInfo.getUser_division_id());
		// 유저 DTO로 변경하기
		// 성공하면 유저정보 변경하기
		session.setAttribute(SessionConst.LOGIN_MEMBER, loginUser);

    	return ResponseEntity.ok()
    			.body("성공");
    }
    
    
    /**
     * 기능 : 회원의 유저 구분 아이디를 '학생'으로 변경할 수 있습니다.
     */
    @ResponseBody
    @PostMapping("/users/divisionid/student")
    public ResponseEntity<?> changeUserDivisionIdForStudent(@SessionAttribute(value = SessionConst.LOGIN_MEMBER) LoginSuccessDTO user, HttpSession session) {
    	
    	String userDivisionId = "S";
    	userService.updateUserDivisionId(user.getId(), userDivisionId);
    	// 유저 정보 불러오기
		User userInfo = userService.findByIdV2(user.getId());
		LoginSuccessDTO loginUser = LoginSuccessDTO.create(userInfo.getId(), userInfo.getUser_id(), userInfo.getUser_division_id());
		// 유저 DTO로 변경하기
		// 성공하면 유저정보 변경하기
		session.setAttribute(SessionConst.LOGIN_MEMBER, loginUser);
    	
    	return ResponseEntity.ok()
    			.body("성공");
    }
}

