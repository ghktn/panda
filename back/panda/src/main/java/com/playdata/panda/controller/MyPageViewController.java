package com.playdata.panda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPageViewController {

    @GetMapping("/myclass-list")
    public String myClassListViewPage() {
        return "class/my-classlist";
    }
    @GetMapping("/certification-submit")
    public String teacherCertificationViewPage() {
        return "member/certification-teacher";
    }
    @GetMapping("/myapply-list")
    public String myapplyListViewPage() {
        return "member/my-applylist";
    }
    @GetMapping("/myinfo-update")
    public String myinfoUpdateViewPage() {
        return "member/my-info-update";
    }

    @GetMapping("/review-register")
    public String reviewRegisterViewPage() {
        return "review/class-review-write";
    }
    @GetMapping("/myconcern-list")
    public String myconcernListViewPage() {
        return "member/concern-list";
    }
}
