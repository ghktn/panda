package com.playdata.panda.repository;

import com.playdata.panda.dto.User;
import com.playdata.panda.dto.LoginDTO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

	/**
	 * 기능 : 회원가입을 할 수 있습니다.
	 * @param user
	 * @return
	 */
    public int signUpUser(User user);
    
    /**
     * 기능 : 회원을 불러올 수 있습니다
     */
    public User findByUserIdAndPassword(LoginDTO userDto);

}
