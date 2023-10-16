package com.playdata.panda.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.playdata.panda.dto.PandaClass;


/**
 * ClassTestRepository
 * @author Playdata
 * 기능 : 수업을 불러온다.
 * 
 * TODO : 수업 repository와 합한다.
 */
@Mapper
public interface ClassTestRepository {
	
	/**
	 * 기능 : 수업 불러오기 회원 아이디에 따른
	 * @param userId 
	 */
	List<PandaClass> findByClassRegUserId(Long userId); 

}
