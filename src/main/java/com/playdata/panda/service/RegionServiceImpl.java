package com.playdata.panda.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.playdata.panda.dto.RegionEmd;
import com.playdata.panda.dto.RegionSd;
import com.playdata.panda.dto.RegionSgg;
import com.playdata.panda.repository.RegionRepository;
import com.playdata.panda.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@ControllerAdvice
public class RegionServiceImpl implements RegionService {
	private final RegionRepository regionRepository;
	
	@Override
    public List<RegionSd> findRegionSdList(){
    	return regionRepository.findRegionSdList();
    }
    
    @Override
    public List<RegionSgg> findRegionSggList(int sd_code){
    	return regionRepository.findRegionSggList(sd_code);
    }
    
    @Override
    public List<RegionEmd> findRegionEmdList(int sgg_code){
    	return regionRepository.findRegionEmdList(sgg_code);
    }
}
