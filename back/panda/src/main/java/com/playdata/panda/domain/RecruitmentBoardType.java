package com.playdata.panda.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecruitmentBoardType {
	
	private String recruitment_board_id;// 게시판 종류 아이디			CHAR(2)
	private String board_name;// 게시판 종류 이름						VARCHAR2(100)
	private String board_info;// 게시판 종류 설명                     	VARCHAR2(255)
}
