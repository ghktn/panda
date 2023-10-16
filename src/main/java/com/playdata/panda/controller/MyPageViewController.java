package com.playdata.panda.controller;

import com.playdata.panda.dto.CategoryMain;
import com.playdata.panda.dto.CategorySub;
import com.playdata.panda.dto.ConcernList;
import com.playdata.panda.dto.RecruitmentBoard;
import com.playdata.panda.service.ClassService;
import com.playdata.panda.service.ConcernService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MyPageViewController {

    private final ClassService classService;
    private final ConcernService concernService;

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
    public String myConcernListViewPage(Model model) {
        List<ConcernList> concernList = concernService.findMyConcernList();
        model.addAttribute("concernList", concernList);
        System.out.println(concernList);
        return "member/concern-list";
    }

    @GetMapping("/class-write")
    public String classWriteViewPage(Model model) {

        List<CategoryMain> categoryMainList = classService.findCategoryMainList();
        model.addAttribute("categoryMainList", categoryMainList);
        return "class/class-write";
    }
}
