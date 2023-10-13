package com.playdata.panda.service;

import org.springframework.stereotype.Service;
import com.playdata.panda.dto.Application;
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
		applicationRepository.insertApplication(application);
	}
	
}
