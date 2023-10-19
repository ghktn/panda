package com.playdata.panda.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.playdata.panda.dto.Application;
import com.playdata.panda.dto.ApplicationList;
import com.playdata.panda.dto.LoginSuccessDTO;
import com.playdata.panda.repository.ApplicationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService{
	
	private final ApplicationRepository applicationRepository;
	

	@Override
	public void application(Application application, long id) {
		application.setAccept_yn("W");
		
		application.setId(id); //신청자의 아이디
		
		applicationRepository.insertApplication(application);
	}

	@Override
	public List<ApplicationList> selectApplication(LoginSuccessDTO user) {
		if(user.getUser_division_id().equals("T ")) {
			return applicationRepository.selectResultList(user);
		}
		else {
			return applicationRepository.selectApplicationList(user);
		}
	}
	
	//신청목록 삭제
	@Override
	public void deleteApplication(String application_id) {
		applicationRepository.deleteApplication(application_id);
	}
	@Transactional
	@Override
	public void acceptApply(String application_id,String class_id) {
		applicationRepository.acceptApply_yn(application_id);
		applicationRepository.acceptApply_count(class_id);
		
	}

	@Override
	public void rejectApply(String application_id) {
		applicationRepository.rejectApply(application_id);
	}
	
}
