package com.playdata.panda.dto;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApplicationList {
	private int application_id;              //수업신청 아이디
	private long id;                         //유저 고유 아이디(신청자)
	private long class_id;                   //수업 아이디
	private long class_reg_user_id;          //유저 고유 아이디 (수업을 만든 유저)
	private String accept_yn;                //수락/거절 여부
	private String title;                    //제목
	private int max_std_count;               //수업에 참여 가능한 최대 학생
	private int current_std_count;           //수업 참여 중인 현재 학생
	private String nickname;                 //닉네임
	private String profile_photo;            //프로필사진
	private String recruitment_board_id;     //게시판 종류 아이디
}

