package com.playdata.panda.service;

import com.playdata.panda.domain.User;
import com.playdata.panda.dto.LoginDTO;
import com.playdata.panda.dto.LoginSuccessDTO;
import com.playdata.panda.dto.SignUpRegisterDTO;
import org.springframework.stereotype.Service;

public interface UserService {

    User findById();

    void signUp(SignUpRegisterDTO dto);
    
    /**
     * 기능 : 회원이 있는지 여부 확인한다.
     * @param userDto
     */
    LoginSuccessDTO login(LoginDTO userDto);
}
