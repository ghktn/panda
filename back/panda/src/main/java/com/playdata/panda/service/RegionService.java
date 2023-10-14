package com.playdata.panda.service;

import java.util.List;

import com.playdata.panda.dto.RegionEmd;
import com.playdata.panda.dto.RegionSd;
import com.playdata.panda.dto.RegionSgg;

public interface RegionService {

	List<RegionSd> findRegionSdList();

	List<RegionSgg> findRegionSggList(int sd_code);

	List<RegionEmd> findRegionEmdList(int sgg_code);

}
