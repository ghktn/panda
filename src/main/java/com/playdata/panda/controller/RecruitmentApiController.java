package com.playdata.panda.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.playdata.panda.dto.Concern;
import com.playdata.panda.service.ConcernService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.playdata.panda.dto.RecruitmentBoard;
import com.playdata.panda.dto.RecruitmentBoardPandaClassDTO;
import com.playdata.panda.dto.RecruitmentConditionDTO;
import com.playdata.panda.service.RecruitmentBoardService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/recruitments")
@RequiredArgsConstructor
@Controller
public class RecruitmentApiController {

    private final RecruitmentBoardService recruitmentBoardService;
    private final ConcernService concernService;

    /**
     * 기능 : 저장할 수 있습니다.
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<Integer> save(@RequestBody RecruitmentBoard recruitmentBoard) {

        int result = recruitmentBoardService.save(recruitmentBoard);

        return ResponseEntity.ok()
                .body(result);
    }

    /**
     * 기능 : 조건에 따른 데이터 리스트를 조회할 수 있습니다.
     * <p>
     * TODO : Get으로 받아야 하는데 Post로 받는 부분을 수정해야 할 것 같습니다.
     * 	      -> fetch를 사용했을 때 데이터(body)를 넘기는 방법이 있을까요?
     */
    @PostMapping("/search")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> selectAllByCondition(@RequestBody RecruitmentConditionDTO condition) {

        List<RecruitmentBoardPandaClassDTO> boardList = recruitmentBoardService.findAllByCondition(condition);
        Long totalCount = recruitmentBoardService.selectTotalCount(condition);

        // map에 담기
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("boardList", boardList);
        resultMap.put("totalCount", totalCount);

        return ResponseEntity.ok()
                .body(resultMap);
    }
}
