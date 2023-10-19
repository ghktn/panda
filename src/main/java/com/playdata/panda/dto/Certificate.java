package com.playdata.panda.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Certificate {
	private Integer certificate_id;	//증명서 아이디
	private Integer teacher_id;	//선생님 아이디
	private String orginal_file_name;	//증명서 원본 파일 이름
	private String store_file_name;	//증명서 저장 파일 이름
	
	
	// 비즈니스 메서드
	
	/**
	 * 기능 : 증명서를 생성할 수 있습니다.
	 * @param original_file_name
	 * @param store_file_name
	 * @return
	 */
	public static Certificate creaet(String original_file_name, String store_file_name) {
		
		Certificate certificate = new Certificate();

		certificate.setOrginal_file_name(original_file_name);
		certificate.setStore_file_name(store_file_name);
		
		return certificate;
	}



}
