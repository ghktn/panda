package com.playdata.panda.domain;

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Review {
	
	 private int review_id;// 리뷰 아이디 
	 private int class_id;// 수업 아이디
	 private int id;// 리뷰를 남긴 회원 아이디
	 private double score;// 리뷰 별점
	 private String contents;// 리뷰 내용                                                                  VARCHAR2(255)
	 private Date regist_date;// 등록 날짜

}
