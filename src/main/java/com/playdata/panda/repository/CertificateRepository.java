package com.playdata.panda.repository;

import org.apache.ibatis.annotations.Mapper;

import com.playdata.panda.dto.Certificate;

/**
 * Certificate
 * @author Playdata
 * 기능 : 증명서를 DB와 연동할 수 있습니다.
 */
@Mapper
public interface CertificateRepository {
	
	/**
	 * 기능 : 증명서를 저장할 수 있습니다.
	 */
	public int insert(Certificate certificate);
	
	

}
