package com.playdata.panda.service;

import com.playdata.panda.dto.ConcernList;

import java.util.List;

public interface ConcernService {

    List<ConcernList> findMyConcernList();

    int selectConcern(int board_id, long user_id);

    int addConcern(int board_id, long user_id);

    int cancelConcern(int board_id, long user_id);
}
