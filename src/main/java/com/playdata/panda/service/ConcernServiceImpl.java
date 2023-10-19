package com.playdata.panda.service;

import com.playdata.panda.dto.Concern;

import com.playdata.panda.dto.ConcernList;
import com.playdata.panda.dto.ConcernRequestDTO;
import com.playdata.panda.repository.ConcernRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConcernServiceImpl implements ConcernService {

    private final ConcernRepository concernRepository;

    @Override
    public List<ConcernList> findMyConcernList() {
        return concernRepository.findMyConcernList();
    }

    /**
     * 기능 : 상세보기 클릭시 관심 테이블에 유저 id와 게시글 id가 있는지 확인한다.
     */
    @Override
    public int selectConcern(int board_id, long user_id) {
        ConcernRequestDTO concernRequestDTO = new ConcernRequestDTO(user_id, board_id);
        return concernRepository.findByIdConcern(concernRequestDTO);
    }

    @Override
    public int addConcern(int board_id, long user_id) {
        Concern concern = new Concern(board_id, user_id);
        return concernRepository.addConcern(concern);
    }

    @Override
    public int cancelConcern(int board_id, long user_id) {
        Concern concern = new Concern(board_id, user_id);
        return concernRepository.cancelConcern(concern);
    }
}
