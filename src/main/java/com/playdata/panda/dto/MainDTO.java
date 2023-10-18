package com.playdata.panda.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MainDTO {
	private long class_id;               //수업 아이디 ffffff
	private long class_reg_user_id;      //유저 고유 아이디(수업을 만든 유저)   fffff
	private long id;                     //유저 고유 아이디(유저 고유 식별번호)
	private int current_std_count;       //수업 참여 중인 현재 학생    fddddffffff
	private int max_std_count;           //수업에 참여 가능한 최대 학생   ffffffffffff
	private int pay;                     //수강비   ggggggggggg
	private String title;                //수업 제목   fffffffffffff
	private String nickname;             //닉네임     
	private String profile_photo;        //profile_photo
}
