package com.playdata.panda.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Notice {
	private int notice_no;	//공지사항번호
	private String notice_title;	//공지사항제목
	private String notice_type;	//분류
	private Date write_date;	//작성일
	private int views;	//조회수
	private String notice_contents;	//공지사항내용
}
