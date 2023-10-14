package com.playdata.panda.service;

import com.playdata.panda.dto.User;
import com.playdata.panda.dto.LoginDTO;
import com.playdata.panda.dto.LoginSuccessDTO;
import com.playdata.panda.dto.RegionEmd;
import com.playdata.panda.dto.RegionSd;
import com.playdata.panda.dto.RegionSgg;
import com.playdata.panda.dto.SignUpRegisterDTO;
import com.playdata.panda.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Service
@RequiredArgsConstructor
@ControllerAdvice
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public User findById() {
        return null;
    }

    @Override
    public void signUp(SignUpRegisterDTO dto) {

        //TODO : 아이디 중복 체크, 닉네임 중복체크 필요
        User user = User.create(dto);

        userRepository.signUpUser(user);
    }
    
    /**
     * 기능 : 회원이 있는지 여부 확인한다.
     */
    @Override
    public LoginSuccessDTO login(LoginDTO userDto) {
    	
    	// 유저가 있는지 확인한다.
     	User user = userRepository.findByUserIdAndPassword(userDto);
    	// 회원이 없으면 UserNotExistException을 던진다.
     	if(user == null) {
     		return null;
     	}
    	// 회원이 있으면 성공한다.
     	return LoginSuccessDTO.create(user.getId(), user.getUser_id());
    }
    
    
    
}
