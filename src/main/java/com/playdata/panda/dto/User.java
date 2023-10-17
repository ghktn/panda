package com.playdata.panda.dto;

import lombok.*;

import java.sql.Date;


@Getter
@Builder
@ToString
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
    private Integer badge_id;
    
    
    public static User create(SignUpRegisterDTO signUpRegisterDTO) {

        String birthday = signUpRegisterDTO.getYear() + "-" + signUpRegisterDTO.getMonth() + "-" + signUpRegisterDTO.getDate();
//        Date birthday = Date.valueOf(birthdayStr);

        return User.builder()
                .name(signUpRegisterDTO.getName())
                .gender(signUpRegisterDTO.getGender())
                .birthday(birthday)
                .nickname(signUpRegisterDTO.getNickname())
                .user_id(signUpRegisterDTO.getUser_id())
                .password(signUpRegisterDTO.getPassword())
                .email(signUpRegisterDTO.getEmail())
                .sd_code(signUpRegisterDTO.getSd_code())
                .sgg_code(signUpRegisterDTO.getSgg_code())
                .emd_code(signUpRegisterDTO.getEmd_code())
                .build();
    }



}
