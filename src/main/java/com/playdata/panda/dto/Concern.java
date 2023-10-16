package com.playdata.panda.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Concern {
    private int concern_id;        //관심 아이디
    private int recruitment_std_id;    //게시글 아이디
    private int user_id;        //유저 고유 아이디
    private Date concern_date;        //관심등록 일자
}
