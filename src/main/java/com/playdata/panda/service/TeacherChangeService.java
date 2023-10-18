package com.playdata.panda.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.playdata.panda.dto.TeacherChange;
import com.playdata.panda.dto.TeacherChangeRequestDTO;

public interface TeacherChangeService {

	/**
	 * 기능 : 선생님 정보를 저장할 수 있습니다.
	 */
	void save(TeacherChangeRequestDTO teacherChangeRequestDto, long userId, List<MultipartFile> files);

}
