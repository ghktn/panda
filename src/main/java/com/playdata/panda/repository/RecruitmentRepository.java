package com.playdata.panda.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.playdata.panda.dto.RecruitmentBoard;
import com.playdata.panda.dto.RecruitmentBoardPandaClassDTO;
import com.playdata.panda.dto.RecruitmentConditionDTO;

/**
 * RecruitmentRepository
 * @author Playdata
 * 기능 : 수업 모집 공고 table DB와 소통할 수 있습니다. 
 */
@Mapper
public interface RecruitmentRepository {
	
	/**
	 * 기능 : 저장할 수 있습니다.
	 */
	int saveOne(RecruitmentBoard recruitmentBoard);
	
	/**
	 * 기능 : 모든 데이터를 조회할 수 있습니다.
	 */
	List<RecruitmentBoardPandaClassDTO> findAll();
	
	/**
	 * 기능 : 한 개의 데이터를 조회할 수 있습니다.
	 */
	RecruitmentBoardPandaClassDTO findById(int id);

	/**
	 * 기능 : 조건에 따른 모든 데이터를 조회할 수 있습니다.
	 */
	List<RecruitmentBoardPandaClassDTO> findAllByCondtion(RecruitmentConditionDTO condition);
	
	/**
	 * 기능 : 조건에 따른 전체 개수를 조회할 수 있습니다.
	 */
	Long findTotalCount(RecruitmentConditionDTO condition);

}
