package com.playdata.panda.dto;

import java.util.DoubleSummaryStatistics;

import lombok.Getter;
import lombok.Setter;

@Getter
public class TeacherChange {

	private int teacher_id;	//선생님 아이디
	private int id;	//유저 고유 아이디
	private int category_main_id;	//카테고리 대분류 아이디
	private int category_sub_id;	//카테고리 소분류 아이디
	private String teacher_introduce;	//선생님 소개글

	public TeacherChange(int id, int category_main_id, int category_sub_id, String teacher_introduce) {
		super();
		this.id = id;
		this.category_main_id = category_main_id;
		this.category_sub_id = category_sub_id;
		this.teacher_introduce = teacher_introduce;
	}

	// 비즈니스 메서드
	/**
	 * 기능 : 선생님 정보 생성할 수 있습니다.
	 * @return
	 */
	public static TeacherChange create(int id, int category_main_id, int category_sub_id, String teacher_introduce) {

		TeacherChange teacherCange = new TeacherChange(
				id,
				category_main_id,
				category_sub_id,
				teacher_introduce
		);

		return teacherCange;
	}

}