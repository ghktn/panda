package com.playdata.panda.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginSuccessDTO {

    private long id;
    private String userId;
    private String user_division_id;

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

	public static LoginSuccessDTO create(long id, String userId) {
        return new LoginSuccessDTO(id, userId);
    }

	public static LoginSuccessDTO create(long id, String userId,String user_division_id) {
		return new LoginSuccessDTO(id, userId,user_division_id);
	}

}
