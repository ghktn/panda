package com.playdata.panda.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PandaClass {
	private int class_id;	//수업아이디
	private int class_reg_user_id;		//유저 고유 아이디
	private int category_main_id;	//카테고리 대분류 아이디
	private int category_sub_id;	//카테고리 소분류 아이디
	private int sd_code;		//시도 코드
	private int sgg_code;		//시군구 코드
	private int emd_code;	//읍면동 코드
	private String class_status;	//수업 상태
	private String title;	//수업 제목
	private String cinfo;		//수업소개
	private int max_std_count;	//수업에 참여 가능한 최대 학생
	private int current_std_count;	//수업 참여 중인 현재 학생
	private String std_gender;	//모집대상 성별
	private String std_age_group;		//모집대상 연령대
	private int pay;		//수강비
	private int wish_study_count;		//수업 희망 횟수
	private String wish_days;		//수업 희망 요일
	private String lecture_type;	//수업형태 빠져있음 수정
	private int application_count;	//신청 요청 받은 수
	
	
}
