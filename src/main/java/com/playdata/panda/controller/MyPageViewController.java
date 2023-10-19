package com.playdata.panda.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.playdata.panda.dto.CategoryMain;
import com.playdata.panda.dto.ClassListDTO;
import com.playdata.panda.dto.ConcernList;
import com.playdata.panda.dto.LoginSuccessDTO;
import com.playdata.panda.dto.RegionSd;
import com.playdata.panda.service.ClassService;
import com.playdata.panda.service.ConcernService;
import com.playdata.panda.service.RegionService;
import com.playdata.panda.service.UserService;
import com.playdata.panda.util.SessionConst;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MyPageViewController {
	
	
	private final ClassService classService;
	private final ConcernService concernService;
	private final RegionService regionService;
	private final UserService userService;

    @GetMapping("/myclass-list")
    public String myClassListViewPage(@SessionAttribute(value=SessionConst.LOGIN_MEMBER) LoginSuccessDTO user,Model model) {
    	 List<ClassListDTO> dto = classService.selectClassList(user);
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
    
	// 회원정보 수정 전에 디비 불러오기
	@GetMapping("/myinfo-update")
	public String myinfoUpdateViewPage(String userId, Model model, HttpSession session) {
		//User userInfo = userService.selectMyInfo(userId);
		//model.addAttribute("userInfo", userInfo);
		//System.out.println(userInfo);
		// User에 담긴 정보를 sysout출력하고 모델에 저장하고 작업
		
		return "member/my-info-update";
	}

    @GetMapping("/review-register")
    public String reviewRegisterViewPage(String class_id,String cmd, Model model) {
    	ClassListDTO cdto=classService.getClassInfo(class_id);		
		String view = "";
		if(cmd.equals("view")) {
			view="review/class-review-write";
		}
		else {
			view="board/update";
		}
		model.addAttribute("classInfo",cdto);
		return view;
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
