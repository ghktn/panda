package com.playdata.panda.service;

import com.playdata.panda.dto.User;
import com.playdata.panda.dto.LoginDTO;
import com.playdata.panda.dto.LoginSuccessDTO;
import com.playdata.panda.dto.SignUpRegisterDTO;
import com.playdata.panda.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
    public void signUp(SignUpRegisterDTO dto) throws ParseException {

        //TODO : 아이디 중복 체크, 닉네임 중복체크 필요

        /**
         * 받은 year, month, date를 birthday로 변경하는 로직
         */
        String dataString = dto.getYear() + "-" + dto.getMonth() + "-" + dto.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dto.setBirthday(dateFormat.parse(dataString));

        userRepository.signUpUser(dto);
    }


    /**
     * 기능 : 회원이 있는지 여부 확인한다.
     */
    @Override
    public LoginSuccessDTO login(LoginDTO userDto) {

        // 유저가 있는지 확인한다.
        User user = userRepository.findByUserIdAndPassword(userDto);
        // 회원이 없으면 UserNotExistException을 던진다.
        if (user == null) {
            return null;
        }
        // 회원이 있으면 성공한다.
        return LoginSuccessDTO.create(user.getId(), user.getUser_id());
    }
}
