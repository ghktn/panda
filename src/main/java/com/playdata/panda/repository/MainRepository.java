package com.playdata.panda.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.playdata.panda.dto.MainDTO;

@Mapper
public interface MainRepository {
	
	List<MainDTO> selectMain();
}


