package com.playdata.panda.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Application {
	private int application_id;
	private long id;
	private long class_id;
	private String accept_yn; 
	private String application_contents;
	private Date reg_date;
}
