package com.playdata.panda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.playdata.panda.dto.LoginDTO;
import com.playdata.panda.dto.LoginSuccessDTO;
import com.playdata.panda.dto.TeacherChange;
import com.playdata.panda.dto.TeacherChangeRequestDTO;
import com.playdata.panda.service.TeacherChangeService;
import com.playdata.panda.util.SessionConst;

import lombok.RequiredArgsConstructor;

/**
 * 기능 : 선생님 정보를 처리할 수 있습니다.
 */
@RequestMapping("/teacherchange")
@Controller
@RequiredArgsConstructor
public class TeacherChangeViewController {
	
	private final TeacherChangeService tcService;

}
