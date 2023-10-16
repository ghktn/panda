package com.playdata.panda.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegionEmd {
	private int emd_code;// 읍면동 코드
	private String emd_name;// 읍면동명
	private int sgg_code;
}
