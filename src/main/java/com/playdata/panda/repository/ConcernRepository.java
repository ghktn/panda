package com.playdata.panda.repository;

import com.playdata.panda.dto.Concern;
import com.playdata.panda.dto.ConcernList;
import com.playdata.panda.dto.ConcernRequestDTO;
import com.playdata.panda.dto.RecruitmentBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConcernRepository {

    List<ConcernList> findMyConcernList();

    int findByIdConcern(ConcernRequestDTO dto);

    int addConcern(Concern concern);

    int cancelConcern(Concern concern);

}
