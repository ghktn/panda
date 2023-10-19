package com.playdata.panda.repository;

import org.apache.ibatis.annotations.Mapper;

import com.playdata.panda.dto.TeacherChange;

@Mapper
public interface TeacherChangeRepository {
	
	/**
	 * 기능 : 선생님 정보를 저장할 수 있습니다.
	 */
	public void insert(TeacherChange teacherChange);
	
	/**
	 * 기능 : 유저 아이디로 선생님 아이디를 불러올 수 있습니다.
	 */
	int findTeacherIdById(int userId);

	/**
	 * 기능 : 유저 아이디에 따른 선생님 정보를 불러올 수 있습니다.
	 */
	public TeacherChange findByUserId(long id);


}
