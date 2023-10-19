package com.playdata.panda.dto;

import lombok.Getter;

import lombok.Setter;

@Setter
@Getter
public class ClassListDTO {
	private int class_id;	//수업아이디
	private String title;	//수업 제목
	private String class_status; //수업 상태
	private int category_sub_id; //카테고리 소분류 아이디
	private int current_std_count;	//수업 참여 중인 현재 학생
	private int max_std_count;	//수업에 참여 가능한 최대 학생
	private int pay;		//희망수강비
	private String category_sub_name; //카테고리 서	브 이름
	private String nickname; //선생님 닉네임
	private String class_reg_user_id; //수업 만든 아이디
	private String profile_photo; //프로필 사진
	
}


