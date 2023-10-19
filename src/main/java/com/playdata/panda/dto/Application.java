package com.playdata.panda.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Application {
	private int application_id;              //수업신청 아이디
	private long id;                         //유저 고유 아이디
	private long class_id;                   //수업 아이디
	private String accept_yn;                //수락/거절 여부
	private String application_contents;     //신청 내용
	private Date reg_date;                   //등록일
}
