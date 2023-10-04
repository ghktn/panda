package com.playdata.panda.service;

import com.playdata.panda.domain.User;
import com.playdata.panda.dto.SignUpRegisterDTO;
import org.springframework.stereotype.Service;

public interface UserService {

    User findById();

    void signUp(SignUpRegisterDTO dto);


}
