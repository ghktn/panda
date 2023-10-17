package com.playdata.panda.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.playdata.panda.dto.CategoryMain;
import com.playdata.panda.dto.ClassListDTO;
import com.playdata.panda.dto.ConcernList;
import com.playdata.panda.dto.RegionSd;
import com.playdata.panda.service.ClassService;
import com.playdata.panda.service.ConcernService;
import com.playdata.panda.service.RegionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MyPageViewController {

    private final ClassService classService;
    private final ConcernService concernService;
    private final RegionService regionService;

    @GetMapping("/myclass-list")
    public String myClassListViewPage(Model model) {
    	 List<ClassListDTO> dto = classService.selectClassList();
    	 model.addAttribute("classInfo",dto);
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
        List<RegionSd> regionSdList = regionService.findRegionSdList();
        model.addAttribute("regionSdList", regionSdList);
        model.addAttribute("categoryMainList", categoryMainList);
        return "class/class-write";
    }
}
