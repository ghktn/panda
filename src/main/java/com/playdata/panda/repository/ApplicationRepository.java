package com.playdata.panda.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.playdata.panda.dto.Application;
import com.playdata.panda.dto.ApplicationList;
import com.playdata.panda.dto.LoginSuccessDTO;

@Mapper
public interface ApplicationRepository {

	public void insertApplication(Application application);
	//선생 신청목록
	List<ApplicationList> selectResultList(LoginSuccessDTO user);
	//학생 신청목록
	List<ApplicationList> selectApplicationList(LoginSuccessDTO user);
	//신청목록 삭제
	void deleteApplication(String application_id);
	void acceptApply_yn(String application_id);
	void acceptApply_count(String class_id);
	void rejectApply(String application_id);
		
}
