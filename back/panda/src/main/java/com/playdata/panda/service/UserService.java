package com.playdata.panda.service;

import com.playdata.panda.dto.User;

import java.util.List;

import com.playdata.panda.dto.LoginDTO;
import com.playdata.panda.dto.LoginSuccessDTO;
import com.playdata.panda.dto.RegionEmd;
import com.playdata.panda.dto.RegionSd;
import com.playdata.panda.dto.RegionSgg;
import com.playdata.panda.dto.SignUpRegisterDTO;

public interface UserService {

    User findById();

    void signUp(SignUpRegisterDTO dto);
    
    /**
     * 기능 : 회원이 있는지 여부 확인한다.
     * @param userDto
     */
    LoginSuccessDTO login(LoginDTO userDto);


    
}
