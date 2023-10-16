package com.playdata.panda.service;

import com.playdata.panda.dto.User;
import com.playdata.panda.dto.LoginDTO;
import com.playdata.panda.dto.LoginSuccessDTO;
import com.playdata.panda.dto.SignUpRegisterDTO;

import java.text.ParseException;

public interface UserService {

    User findById();

    void signUp(SignUpRegisterDTO dto) throws ParseException;
    
    /**
     * 기능 : 회원이 있는지 여부 확인한다.
     * @param userDto
     */
    LoginSuccessDTO login(LoginDTO userDto);
}
