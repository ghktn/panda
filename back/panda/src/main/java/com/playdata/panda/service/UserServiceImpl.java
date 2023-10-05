package com.playdata.panda.service;

import com.playdata.panda.domain.User;
import com.playdata.panda.dto.SignUpRegisterDTO;
import com.playdata.panda.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public User findById() {
        return null;
    }

    @Override
    public void signUp(SignUpRegisterDTO dto) {
        //todo : 아이디 중복 체크, 닉네임 중복체크 필요
        User user = User.create(dto);
        userRepository.signUpUser(user);
    }
}
