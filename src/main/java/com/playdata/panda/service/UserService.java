package com.playdata.panda.service;

import java.text.ParseException;

import com.playdata.panda.dto.LoginDTO;
import com.playdata.panda.dto.LoginSuccessDTO;
import com.playdata.panda.dto.SignUpRegisterDTO;
import com.playdata.panda.dto.User;

import java.text.ParseException;
import java.util.Map;

public interface UserService {

    User findById();

    void signUp(SignUpRegisterDTO dto) throws ParseException;
    
    /**
     * 기능 : 회원이 있는지 여부 확인한다.
     * @param userDto
     */
    LoginSuccessDTO login(LoginDTO userDto);
    
    /**
     * 기능 : 마이페이지에 회원정보를 불러올 수 있다.
     */
	User selectMyInfo(String userId);
	
	/**
     * 기능 : 회원 정보 수정에서 회원 정보를 수정할 수 있다.
     */
	void updateMyInfo(User users);
	
	/**
     * 기능 : 회원 정보를 불러올 수 있다.
     */
	LoginSuccessDTO findByUserId(User user);


    
    /**
     * 기능 : 회원 정보를 수정할 수 있습니다.
     * @param parameters
     */
	void updateUserDivisionId(Long userId, String userDivisionId);

	/**
     * 기능 : 회원 정보를 불러올 수 있습니다.
     */
	User findByIdV2(Long id);

}
