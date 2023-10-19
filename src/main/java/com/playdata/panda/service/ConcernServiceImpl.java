package com.playdata.panda.service;

import com.playdata.panda.dto.ConcernList;
import com.playdata.panda.dto.RecruitmentBoard;
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

}
