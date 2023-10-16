package com.playdata.panda.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Scedule {
	
	private int scedule_id;// 일정 아이디				NUMBER(19)
	private int class_id;// 수업 아이디					NUMBER(19)
	private Date class_date;// 일정 날짜				DATE
	private String class_notice;// 일정 내용        	VARCHAR2(255)
}
