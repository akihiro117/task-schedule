package com.webapp.taskschedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp.taskschedule.form.MemberRegistrationForm;

@Controller
public class RegistMemberController {
	@RequestMapping("/RegistForm")
	String showRegistMemberForm() {

		return "RegistForm";
	}

	@RequestMapping("/MemberRegistrationConfirm")
	String showRegistrationConfirm(@ModelAttribute MemberRegistrationForm form) {
		return "MemberRegistrationConfirm";
	}

}
