package com.playdata.panda.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Recruitment_board {
	
	 private int recuruitment_id;// 게시글 아이디           		NUMBER(19)
	 private int id;// 유저 고유 아이디                          	NUMBER(19)
	 private String recruitment_board_id;// 게시판 종류 아이디		CHAR(2)
	 private int class_id;// 수업 아이디							NUMBER(19)
	 private String title;// 제목                       		VARCHAR2(255)
	 private String contents;// 공고 내용                   	VARCHAR2(255)
	 private String wish_pay;// 희망 수강비   					VARCHAR2(20)
	 private String concern_count;// 관심수						NUMBER(11)
	 private Date reg_date;// 등록일							DATE
	 private Date deadline_date;// 마감일						DATE
	 
}
