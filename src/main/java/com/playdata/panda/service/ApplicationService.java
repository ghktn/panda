package com.playdata.panda.service;

import java.util.List;

import com.playdata.panda.dto.Application;
import com.playdata.panda.dto.ApplicationList;
public interface ApplicationService {
	
	Application insertApplication();
	public void application(Application application,long id);

	List<ApplicationList> selectApplication();
	
	//신청목록 삭제
	void deleteApplication(String application_id);
}
