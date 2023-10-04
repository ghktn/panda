package com.playdata.panda.dto;

import com.playdata.panda.domain.User;
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
    private String birthday;
    private String nickname;
    private String user_id;
    private String password;
    private String email;
    private String sd_code;
    private String sgg_code;
    private String emd_code;

    public User createUser() {

        String birthday = year + "-" + month + "-" + date;

//        return User.builder()
//                .name(name)
//                .gender(gender)
//                .birthday(birthday)
//                .nickname(nickname)
//                .user_id(user_id)
//                .password(password)
//                .email(email)
//                .sd_code(sd_code)
//                .sgg_code(sgg_code)
//                .emd_code(emd_code)
//                .build();

        return User.builder()
                .name("a")
                .gender("a")
                .birthday("a")
                .nickname("a")
                .user_id("a")
                .password("a")
                .email("a")
                .sd_code("a")
                .sgg_code("a")
                .emd_code("a")
                .build();
    }
}
