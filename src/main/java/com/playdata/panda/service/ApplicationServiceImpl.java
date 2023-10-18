package com.playdata.panda.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.playdata.panda.dto.Application;
import com.playdata.panda.dto.ApplicationList;
import com.playdata.panda.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService{
	
	private final ApplicationRepository applicationRepository;
	
	@Override
	public Application insertApplication() {
		return null;
	}

	@Override
	public void application(Application application) {
		application.setAccept_yn("W");
		application.setClass_id(2);
		application.setId(2); //신청자의 아이디
		
		applicationRepository.insertApplication(application);
	}

	@Override
	public List<ApplicationList> selectApplication() {
		return applicationRepository.selectApplication();
	}
	
	//신청목록 삭제
	@Override
	public void deleteApplication(String application_id) {
		applicationRepository.deleteApplication(application_id);
	}

}
