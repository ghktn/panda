package com.playdata.panda.service;

import java.text.ParseException;

import com.playdata.panda.dto.LoginDTO;
import com.playdata.panda.dto.LoginSuccessDTO;
import com.playdata.panda.dto.SignUpRegisterDTO;
import com.playdata.panda.dto.User;

public interface UserService {

    User findById();

    void signUp(SignUpRegisterDTO dto) throws ParseException;
    
    /**
     * 기능 : 회원이 있는지 여부 확인한다.
     * @param userDto
     */
    LoginSuccessDTO login(LoginDTO userDto);

	User selectMyInfo(String userId);

	void updateMyInfo(User users);

	LoginSuccessDTO findByUserId(User user);


}
