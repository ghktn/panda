package com.playdata.panda.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ConcernList {
    private Long recruitment_id;
    private String title;
    private String category_sub_name;
    private String board_name;
    private int current_std_count;
    private String wish_pay;
    private String nickname;
}
