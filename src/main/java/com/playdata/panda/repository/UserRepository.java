package com.playdata.panda.repository;

import com.playdata.panda.dto.SignUpRegisterDTO;
import com.playdata.panda.dto.User;
import com.playdata.panda.dto.LoginDTO;
import com.playdata.panda.dto.LoginSuccessDTO;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

	/**
	 * 기능 : 회원가입을 할 수 있습니다.
	 * @param user
	 * @return
	 */
    public int signUpUser(SignUpRegisterDTO user);
    
    /**
     * 기능 : 회원을 불러올 수 있습니다
     */
    public User findByUserIdAndPassword(LoginDTO userDto);

	public User selectMyInfo(String userId);

	public void updateMyInfo(User users);

	public LoginSuccessDTO findByUserId(User user);

    /**
     * 기능 : 회원 정보를 수정할 수 있습니다.
     * commnet : 현재(10.18~)
     *           -> 회원 구분 아이디를 변경할 수 있습니다.
     */
	public void updateUserDivisionId(Map<String, Object> parameters);

	/**
     * 기능 : 회원 정보를 불러올 수 있습니다.
     * comment: TODO : 우진님 pull 받으면 반환값 User -> LoginSuccessDTO로 바꿔야 한다. 
     */
	public User findByIdV2(Long id);

}
