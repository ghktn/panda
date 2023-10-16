package com.playdata.panda.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RecruitmentConditionDTO {
	
	private int[] categoryList;// 카테고리 리스트
	private int[] locationList;// 시도 리스트
	private int[] maxStdCountList;// 인원수 리스트
	private int[] payPriceList;// 수강료(low, high)
	private String[] wishDayList;// 수업 희망 요일  
	private String[] lectureTypeList;// 수업형태 리스트
	private String[] genderList;// 모집대상 성별 리스트

	private String wishDayListStr;// 모양 : 'a,b,c'
	
	// page 처리
	private long count;// 전체 리스트 개수
	private int bound;// 한 페이지 당 나오는 게시글 개수
	private int nowPage;// 현재 페이지
	
	public RecruitmentConditionDTO() {
		// 처음 리스트 나올 때 초기화
		this.bound = 16;
		this.nowPage = 1;
	}
	
	// 메서드
	/**
	 * 기능 : wishDayList를 string으로 만들기
	 */
	public void createWishDayListStr() {
		if(this.wishDayList != null & this.wishDayList.length != 0) {
			this.wishDayListStr = String.join(",", this.wishDayList);
		} else {
			this.wishDayListStr = "";
		}
	}

}
