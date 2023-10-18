package com.playdata.panda.service;

import java.util.List;

import com.playdata.panda.dto.Concern;
import org.springframework.stereotype.Service;

import com.playdata.panda.dto.RecruitmentBoard;
import com.playdata.panda.dto.RecruitmentBoardPandaClassDTO;
import com.playdata.panda.dto.RecruitmentConditionDTO;
import com.playdata.panda.repository.RecruitmentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RecruitmentBoardServiceImpl implements RecruitmentBoardService {
	
	private final RecruitmentRepository recruitmentRepository;
	
	/**
	 * 기능 : 저장할 수 있습니다.
	 */
	@Override
	public int save(RecruitmentBoard recruitmentBoard) {
		
		return recruitmentRepository.saveOne(recruitmentBoard);
	}
	
	/**
	 * 기능 : 모든 데이터를 조회할 수 있습니다.
	 */
	@Override
	public List<RecruitmentBoardPandaClassDTO> selectAll() {
		
		return recruitmentRepository.findAll();
	}
	
	/**
	 * 기능 : 한 개의 데이터를 조회할 수 있습니다.
	 */
	@Override
	public RecruitmentBoardPandaClassDTO selectOne(int id) {
		
		return recruitmentRepository.findById(id);
	}

	/**
	 * 기능 : 조건에 따른 모든 데이터를 조회할 수 있습니다.
	 */
	@Override
	public List<RecruitmentBoardPandaClassDTO> findAllByCondition(RecruitmentConditionDTO condition) {
		// wishDayList를 string으로 만들기
		condition.createWishDayListStr();
		// list 데이터 요청하기
		List<RecruitmentBoardPandaClassDTO> boardList = recruitmentRepository.findAllByCondtion(condition);

		return boardList;		
	}
	
	/**
	 * 기능 : 조건에 따른 전체 개수 불러오기
	 */
	@Override
	public Long selectTotalCount(RecruitmentConditionDTO condition) {
		// 전체 개수 불러오기
		Long totalCount = recruitmentRepository.findTotalCount(condition);
		return totalCount;
	}

}
