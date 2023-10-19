package com.playdata.panda.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.playdata.panda.dto.MainDTO;
import com.playdata.panda.repository.MainRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService{
	
	private final MainRepository mainRepository;
	
	public List<MainDTO> selectMain(){
		return mainRepository.selectMain();
	}
}
