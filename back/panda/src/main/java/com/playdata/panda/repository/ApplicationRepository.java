package com.playdata.panda.repository;

import org.apache.ibatis.annotations.Mapper;
import com.playdata.panda.dto.Application;

@Mapper
public interface ApplicationRepository {

	public void insertApplication(Application application);
		
}
