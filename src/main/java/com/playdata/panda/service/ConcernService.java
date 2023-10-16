package com.playdata.panda.service;

import com.playdata.panda.dto.ConcernList;
import com.playdata.panda.dto.RecruitmentBoard;

import java.util.List;

public interface ConcernService {

    List<ConcernList> findMyConcernList();
}
