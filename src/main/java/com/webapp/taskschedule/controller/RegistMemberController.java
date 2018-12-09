package com.webapp.taskschedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.webapp.taskschedule.form.MemberRegistrationForm;

@Controller
@SessionAttributes(value = "form")
public class RegistMemberController {


	@RequestMapping("/RegistForm")
	String showRegistMemberForm() {

		return "RegistForm";
	}

	@RequestMapping("/MemberRegistrationConfirm")
	String showRegistrationConfirm(@ModelAttribute MemberRegistrationForm form,
			Model model) {
		//TODO:サーバーサイドの入力チェックを実装。

		//確認画面への表示と登録をするため、値をsessionにセット。
		model.addAttribute("form", form);

		return "MemberRegistrationConfirm";
	}

	@RequestMapping("/MemberRegistrationResult")
	String registMember() {

		return "MemberRegistrationResult";
	}

}
