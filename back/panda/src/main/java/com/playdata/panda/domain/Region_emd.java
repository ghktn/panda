package com.playdata.panda.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Region_emd {
	
	private int emd_code;// 읍면동 코드				NUMBER(5)
	private String emd_name;// 읍면동명			VARCHAR2(30)
}
