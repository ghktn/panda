package com.playdata.panda.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@NoArgsConstructor
public class LoginSuccessDTO {

	private long id;
	private String userId;
	private String nickname;
	private String user_division_id;
	private String email;
	private String gender;
	private String self_introduction_comment;
	private String name;
	private String password;
	private String profile_photo;

    public LoginSuccessDTO(long id, String userId) {
        super();
        this.id = id;
        this.userId = userId;
    }

    public LoginSuccessDTO (long id, String userId, String user_division_id) {
		super();
		this.id = id;
		this.userId = userId;
		this.user_division_id = user_division_id;
	}
	
	public LoginSuccessDTO(long id, String userId, String nickname, String user_division_id, String email,
			String gender, String self_introduction_comment, String name, String password, String profile_photo) {
		super();
		this.id = id;
		this.userId = userId;
		this.nickname = nickname;
		this.user_division_id = user_division_id;
		this.email = email;
		this.gender = gender;
		this.self_introduction_comment = self_introduction_comment;
		this.name = name;
		this.password = password;
		this.profile_photo = profile_photo;
	}
	

	public static LoginSuccessDTO create(long id, String userId) {
        return new LoginSuccessDTO(id, userId);
    }

	public static LoginSuccessDTO create(long id, String userId,String user_division_id) {
		return new LoginSuccessDTO(id, userId,user_division_id);
	}

	public static LoginSuccessDTO create(long id, String user_id, String nickname, String user_division_id,
			String email, String gender, String self_introduction_comment, String name, String password, String profile_photo) {
		return new LoginSuccessDTO(id, user_id, nickname, user_division_id, email, gender, self_introduction_comment, name, password, profile_photo);
	}

	public LoginSuccessDTO(String profile_photo) {
		super();
		this.profile_photo = profile_photo;
	}

}
