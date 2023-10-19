package com.playdata.panda.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.playdata.panda.dto.Application;
import com.playdata.panda.dto.ApplicationList;

@Mapper
public interface ApplicationRepository{
	public void insertApplication(Application application);
	
	List<ApplicationList> selectApplication();
	
	//신청목록 삭제
	void deleteApplication(String application_id);
}
	