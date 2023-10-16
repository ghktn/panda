package com.playdata.panda.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.playdata.panda.dto.PandaClass;
import com.playdata.panda.repository.ClassTestRepository;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Playdata
 * TODO : Class 인터페이스 만들기
 */
@RequiredArgsConstructor
@Service
public class ClassTestServiceImpl {
	
	private final ClassTestRepository classTestRepository;
	
	/**
	 * 기능 : 수업 리스트 불러오기 유저아이디에 따른
	 * @param userId
	 * @return
	 */
	public List<PandaClass> selectClassListByUserId(Long userId) {
		return classTestRepository.findByClassRegUserId(userId);
	}
	

}
