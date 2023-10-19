package com.playdata.panda.controller;

import com.playdata.panda.dto.LoginSuccessDTO;
import com.playdata.panda.service.ConcernService;
import com.playdata.panda.util.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class ConcernApiController {

    private final ConcernService concernService;

    @GetMapping("/add-concern")
    public String addConcern(String board_id, HttpSession session) {
        LoginSuccessDTO user = (LoginSuccessDTO) session.getAttribute(SessionConst.LOGIN_MEMBER);
        concernService.addConcern(Integer.parseInt(board_id), user.getId());
        return "redirect:/recruitment/detail/" + board_id;
    }

    @GetMapping("/cancel-concern")
    public String cancelConcern(String board_id, HttpSession session) {
        System.out.println("된다된다된다된다");
        LoginSuccessDTO user = (LoginSuccessDTO) session.getAttribute(SessionConst.LOGIN_MEMBER);
        concernService.cancelConcern(Integer.parseInt(board_id), user.getId());
        return "redirect:/recruitment/detail/" + board_id;
    }
}
