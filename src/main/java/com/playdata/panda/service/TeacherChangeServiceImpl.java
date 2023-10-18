package com.playdata.panda.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.playdata.panda.dto.Certificate;
import com.playdata.panda.dto.TeacherChange;
import com.playdata.panda.dto.TeacherChangeRequestDTO;
import com.playdata.panda.repository.CertificateRepository;
import com.playdata.panda.repository.TeacherChangeRepository;
import com.playdata.panda.util.FileStore;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherChangeServiceImpl implements TeacherChangeService{
	
	private final TeacherChangeRepository tcRepository;
	private final CertificateRepository certificateRepository;

	/**
	 * 기능 : 선생님 정보를 저장할 수 있습니다.
	 */
	@Override
	public void save(TeacherChangeRequestDTO teacherChangeRequestDto, long userId, List<MultipartFile> files) {
		// TeacherCahnge로 변경하기
		int id = (int) userId;
		
		TeacherChange teacherChange = TeacherChange.create(
				id,
				teacherChangeRequestDto.getCategory_main_id(),
				teacherChangeRequestDto.getCategory_sub_id(),
				teacherChangeRequestDto.getTeacher_introduce()
				);
		// 선생님 정보 저장하기
		tcRepository.insert(teacherChange);
		
		// 증명서 파일이 있으면 저장한다.
		if(files != null) {
			// teacher_id 불러오기
			int teacherId = tcRepository.findTeacherIdById(id);
			
			// 증명서 파일 PC에 저장하기
			FileStore fileStore = new FileStore();
			List<Certificate> certificateList = fileStore.saveFileList(files);
			
			// 증명서 정보 저장하기
			certificateList.stream()
			.forEach((certificate) -> {
				// 선생님 아이디 입력하기
				certificate.setTeacher_id(teacherId);
				// 증명서 저장하기
				certificateRepository.insert(certificate);			
			});
		}
		
	}
	
	
	
}
