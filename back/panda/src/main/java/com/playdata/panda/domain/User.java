package com.playdata.panda.domain;

import lombok.*;

import java.util.Date;

@Getter
@Builder
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class User {
    private Long id;
    private String user_division_id;
    private String sd_code;
    private String sgg_code;
    private String emd_code;
    private String user_id;
    private String password;
    private String name;
    private String nickname;
    private String email;
    private String birthday;
    private String gender;
    private Integer review_score;
    private String profile_photo;
    private String self_introduction_comment;
    private Date reg_date;
    private Date update_date;
    private Date last_con_date;

}
