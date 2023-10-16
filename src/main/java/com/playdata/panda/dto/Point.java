package com.playdata.panda.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Point {
	private int point_id;	//포인트 아이디
	private int id;		//유저 고유 아이디
	private Date point_create_date;	//포인트 발생 일자		데이터 타입 잘못들어감
	private int point_value;	//포인트 수치
	private String point_type;	//포인트 종류
	private String point_contents;	//포인트 내용
	private String point_use;		//포인트 사용 내역
}
