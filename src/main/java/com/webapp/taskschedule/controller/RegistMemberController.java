package com.webapp.taskschedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistMemberController {
	@RequestMapping("/RegistForm")
	String showRegistMemberForm() {

		return "RegistForm";
	}

}
