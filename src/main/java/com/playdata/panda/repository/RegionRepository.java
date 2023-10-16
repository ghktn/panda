package com.playdata.panda.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.playdata.panda.dto.RegionEmd;
import com.playdata.panda.dto.RegionSd;
import com.playdata.panda.dto.RegionSgg;

@Mapper
public interface RegionRepository {
	
	List<RegionSd> findRegionSdList();

	List<RegionSgg> findRegionSggList(int sd_code);

	List<RegionEmd> findRegionEmdList(int sgg_code);

}
