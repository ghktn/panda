package com.playdata.panda.controller;

import org.springframework.stereotype.Controller;

import com.playdata.panda.service.TeacherChangeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TeacherChangeViewController {
	
	private final TeacherChangeService tcService;
}
