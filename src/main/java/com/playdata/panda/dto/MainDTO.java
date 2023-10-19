package com.playdata.panda.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MainDTO {
	private int class_id;                //수업 아이디
	private int recruitment_id;          //모집공고 아이디
	private int class_reg_user_id;       //유저 고유 아이디(수업을 만든 유저)
	private int id;                      //유저 고유 아이디(유저 고유 식별번호)
	private int current_std_count;       //수업 참여 중인 현재 학생
	private int max_std_count;           //수업에 참여 가능한 최대 학생
	private int pay;                     //수강비
	private String title;                //수업 제목
	private String nickname;             //닉네임     
	private String profile_photo;        //profile_photo
}
