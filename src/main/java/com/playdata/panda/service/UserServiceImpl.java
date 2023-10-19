package com.playdata.panda.service;

import com.playdata.panda.dto.User;
import com.playdata.panda.dto.LoginDTO;
import com.playdata.panda.dto.LoginSuccessDTO;
import com.playdata.panda.dto.SignUpRegisterDTO;
import com.playdata.panda.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.UUID;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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

		// TODO : 아이디 중복 체크, 닉네임 중복체크 필요

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
		return LoginSuccessDTO.create(user.getId(), user.getUser_id(), user.getNickname(), user.getUser_division_id(),
				user.getEmail(), user.getGender(), user.getSelf_introduction_comment(), user.getName(),
				user.getPassword(), user.getProfile_photo());
	}

	/**
	 * 기능 : 회원 정보를 수정할 수 있습니다. commnet : 현재(10.18~) -> 회원 구분 아이디를 변경할 수 있습니다.
	 */
	@Override
	public void updateUserDivisionId(Long userId, String userDivisionId) {

		// 유저 정보 선생님으로 전환하기
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", userId);
		parameters.put("userDivisionId", userDivisionId);

		userRepository.updateUserDivisionId(parameters);

	}

	/**
	 * 기능 : 회원 정보를 불러올 수 있습니다.
	 */
	@Override
	public User findByIdV2(Long id) {

		return userRepository.findByIdV2(id);
	}

	@Override
	public User selectMyInfo(String userId) {
		return userRepository.selectMyInfo(userId);
	}

	@Override
	public void updateMyInfo(User users) {
		userRepository.updateMyInfo(users);
	}

	@Override
	public LoginSuccessDTO findByUserId(User user) {
		return userRepository.findByUserId(user);

	}

	public LoginSuccessDTO uploadFile(MultipartFile file, String path) throws IllegalStateException, IOException {
		LoginSuccessDTO loginsuccessdto = new LoginSuccessDTO();
		if (!file.isEmpty()) {
			String profile_photo = file.getOriginalFilename();
//			String storeFilename = createStoreFilename(originalFilename);
//			System.out.println(originalFilename + "," + storeFilename);
//			file.transferTo(new File(path + File.separator + storeFilename));
//			loginsuccessdto = new LoginSuccessDTO(null, originalFilename, storeFilename);
			file.transferTo(new File(path + File.separator));
			loginsuccessdto = new LoginSuccessDTO(profile_photo);
		}
		return loginsuccessdto;

	}
}
