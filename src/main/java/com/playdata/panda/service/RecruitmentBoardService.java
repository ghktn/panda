package com.playdata.panda.service;

import java.util.List;

import com.playdata.panda.dto.RecruitmentBoard;
import com.playdata.panda.dto.RecruitmentBoardPandaClassDTO;
import com.playdata.panda.dto.RecruitmentConditionDTO;

public interface RecruitmentBoardService {

	/**
	 * 기능 : 저장할 수 있습니다.
	 */
	int save(RecruitmentBoard recruitmentBoard);

	/**
	 * 기능 : 모든 데이터를 조회할 수 있습니다.
	 */
	List<RecruitmentBoardPandaClassDTO> selectAll();

	/**
	 * 기능 : 한 개의 데이터를 조회할 수 있습니다.
	 */
	RecruitmentBoardPandaClassDTO selectOne(int id);
	
	/**
	 * 기능 : 조건에 따른 모든 데이터를 조회할 수 있습니다.
	 */
	List<RecruitmentBoardPandaClassDTO> findAllByCondition(RecruitmentConditionDTO condition);

	/**
	 * 기능 : 조건에 따른 전체 개수 불러오기
	 */
	Long selectTotalCount(RecruitmentConditionDTO condition);

}
