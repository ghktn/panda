package com.playdata.panda.dto;

import java.util.Date;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RecruitmentBoardPandaClassDTO {
	
	// recruitment_board
	private int recruitment_id;// 게시글 아이디           		NUMBER(19)
    private int id;// 유저 고유 아이디                          	NUMBER(19)
    private String recruitment_board_id;// 게시판 종류 아이디		CHAR(2)
    private int class_id;// 수업 아이디							NUMBER(19)
    private String title;// 제목                       		VARCHAR2(255)
    private String contents;// 공고 내용                   	VARCHAR2(255)
    private String wish_pay;// 희망 수강비   					VARCHAR2(20)
    private String concern_count;// 관심수						NUMBER(11)
    private Date reg_date;// 등록일							DATE
    private Date deadline_date;// 마감일
    
    // class
	private int class_reg_user_id;		//유저 고유 아이디
	private int category_main_id;	//카테고리 대분류 아이디
	private int category_sub_id;	//카테고리 소분류 아이디
	private int sd_code;		//시도 코드
	private int sgg_code;		//시군구 코드
	private int emd_code;	//읍면동 코드
	private String class_status;	//수업 상태
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
	
	// users
	private String nickname;
	private Integer review_score;
	// TODO : 벳지로 인증여부를 확인해야 한다.
	private Integer badge_id;
	// TODO : 이미지를 확인해야 한다.
	private String profile_photo;
	
	// RegionSd
	private String sd_name;// 시도이름
	
	// RegionSgg
	private String sgg_name;// 시군구명
	
	// RegionEmd
	private String emd_name;// 읍면동명
	
	// CategoryMain
    private String category_main_name;
    
    // CategorySub
    private String category_sub_name;

	
	
	
	
}
