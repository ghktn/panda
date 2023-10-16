package com.playdata.panda.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.playdata.panda.dto.RegionEmd;
import com.playdata.panda.dto.RegionSgg;
import com.playdata.panda.service.RegionService;
import com.playdata.panda.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class RegionApiController {
	private final RegionService regionService;
	
	 @GetMapping("/region_sgg")
	    @ResponseBody
	    public List<RegionSgg> findRegionSggList(int sd_code){
	    	List<RegionSgg> regionSggList = regionService.findRegionSggList(sd_code);
	    	return regionSggList;
	    }
	    
	    @GetMapping("/region_emd")
	    @ResponseBody
	    public List<RegionEmd> findRegionEmdList(int sgg_code){
	    	List<RegionEmd> regionEmdList = regionService.findRegionEmdList(sgg_code);
	    	return regionEmdList;
	    }
}
