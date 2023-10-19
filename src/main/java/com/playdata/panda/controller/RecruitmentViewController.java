package com.playdata.panda.controller;

import java.util.List;

import com.playdata.panda.dto.Concern;
import com.playdata.panda.dto.LoginSuccessDTO;
import com.playdata.panda.service.ConcernService;
import com.playdata.panda.service.ConcernServiceImpl;
import com.playdata.panda.util.SessionConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playdata.panda.dto.RecruitmentBoardPandaClassDTO;
import com.playdata.panda.service.RecruitmentBoardService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@RequestMapping("/recruitment")
@RequiredArgsConstructor
@Controller
public class RecruitmentViewController {

    private final RecruitmentBoardService recruitmentBoardService;
    private final ConcernService concernService;

    /**
     * 기능 : 글쓰기로 이동합니다.
     */
    @GetMapping("/write")
    public String getRecruitmentWrite() {

        return "/recruitment/recruitment-board-write";
    }

    /**
     * 기능 : 리스트 페이지로 이동합니다.
     */
    @GetMapping
    public String getSelectAll(Model model) {

        List<RecruitmentBoardPandaClassDTO> boardList = recruitmentBoardService.selectAll();

        model.addAttribute("boardList", boardList);
        return "/recruitment/recruitment-board";
    }

    /**
     * 기능 : 상세보기로 이동합니다.
     */
    @GetMapping("/detail/{board_id}")
    public String getRecruitmentDetail(HttpSession session, @PathVariable int board_id, Model model) {
        // 정보 불러오기
        RecruitmentBoardPandaClassDTO board = recruitmentBoardService.selectOne(board_id);
        LoginSuccessDTO user = (LoginSuccessDTO) session.getAttribute(SessionConst.LOGIN_MEMBER);
        int concern = concernService.selectConcern(board_id, user.getId());

        model.addAttribute("board", board);
        model.addAttribute("concern", concern);

        return "recruitment/recruitment-detail";
    }

}
