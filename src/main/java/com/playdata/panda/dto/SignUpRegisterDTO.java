package com.playdata.panda.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SignUpRegisterDTO {
    private String name;
    private String gender;
    private String year;
    private String month;
    private String date;
    private Date birthday;
    private String nickname;
    private String user_id;
    private String password;
    private String email;
    private String sd_code;
    private String sgg_code;
    private String emd_code;

}
