package com.playdata.panda.service;

import java.util.List;


import com.playdata.panda.dto.Application;
import com.playdata.panda.dto.ApplicationList;
import com.playdata.panda.dto.LoginSuccessDTO;

public interface ApplicationService {
	
	void application(Application application,long id);
	
	List<ApplicationList> selectApplication(LoginSuccessDTO user);
	//신청목록 삭제
		void deleteApplication(String application_id);

		void acceptApply(String application_id,String class_id);

		void rejectApply(String application_id);	
}

