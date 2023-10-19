package com.playdata.panda.dto;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
public class TeacherChangeRequestDTO {

    private int id;	//유저 고유 아이디
    private int category_main_id;	//카테고리 대분류 아이디
    private int category_sub_id;	//카테고리 소분류 아이디
    private String teacher_introduce;	//선생님 소개글
    private List<MultipartFile> files;// 증명서 리스트

}