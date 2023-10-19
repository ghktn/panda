package com.playdata.panda.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.playdata.panda.dto.CategoryMain;
import com.playdata.panda.dto.CategorySub;
import com.playdata.panda.dto.LoginSuccessDTO;
import com.playdata.panda.dto.TeacherChangeRequestDTO;
import com.playdata.panda.dto.User;
import com.playdata.panda.service.ClassService;
import com.playdata.panda.service.TeacherChangeService;
import com.playdata.panda.service.UserService;
import com.playdata.panda.util.SessionConst;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TeacherChangeApiController {
	
	private final TeacherChangeService tcService;
	private final ClassService classService;
	private final UserService userService;
	
	@GetMapping("/cate-main")
    @ResponseBody
    public List<CategoryMain> findCategoryMainList(){
        List<CategoryMain> categoryMainList = classService.findCategoryMainList();
        return categoryMainList;
    }
	
    @GetMapping("/cate-sub")
    @ResponseBody
    public List<CategorySub> findCategorySubList(int category_main_id){
        List<CategorySub> categorySubList = classService.findCategorySubList(category_main_id);
        return categorySubList;
    }
    
    /**
	 * 기능 : 선생님 정보를 저장할 수 있습니다.
	 * 
	 * TODO : 1. 선생님 정보가 입력되면
	 *        마이페이지에 들어갔을 때 회원의 상태가 학생에서 선생으로 바껴야 한다.(10.18~)
	 *        2. 세션 유저 정보를 변경하는 코드를 반복적으로 사용하지 말고 한번의 메소드로만 처리할 수 없을까?
	 *        3. ***** 
	 */
	@PostMapping("/teacherchange/save")
	@ResponseBody
	public ResponseEntity<String> save(@RequestPart(value = "teacherChange") TeacherChangeRequestDTO teacherChangeRequestDto, 
			@RequestPart(value = "files") List<MultipartFile> files,
			@SessionAttribute(name = SessionConst.LOGIN_MEMBER) LoginSuccessDTO user,
			HttpSession session) {
		
		// 선생님 정보 저장하기
		tcService.save(teacherChangeRequestDto, user.getId(), files);
		// 유저 정보 불러오기
		User userInfo = userService.findByIdV2(user.getId());
		// 성공하면 유저정보 변경하기
		session.setAttribute(SessionConst.LOGIN_MEMBER, userInfo);
		
		return ResponseEntity.ok()
				.body("성공");
	}
}
