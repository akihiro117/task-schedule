//RegistMemberController.java
//Created by Akihiro Yamada on 2018/12/09.
//Copyright (c) 2018. All Rights Reserved.

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

	/**
	 * 会員情報入力画面を表示。
	 * @return 会員情報入力画面。
	 */
	@RequestMapping("/RegistForm")
	String showRegistMemberForm() {

		//会員情報入力画面に遷移。
		return "RegistForm";
	}

	/**
	 * 会員情報登録の確認画面を表示。
	 * 会員情報の入力チェックを行う。
	 * @param form 入力された会員情報。
	 * @param model sessionを渡すために使用するModelオブジェクト。
	 * @return 会員情報登録確認画面。
	 */
	@RequestMapping("/MemberRegistrationConfirm")
	String showRegistrationConfirm(@ModelAttribute MemberRegistrationForm form,
			Model model) {
		//TODO:サーバーサイドの入力チェックを実装。

		//確認画面への表示と登録を行うため、値をsessionにセット。
		model.addAttribute("form", form);

		//会員情報登録確認画面。
		return "MemberRegistrationConfirm";
	}

	/**
	 * 入力された会員情報をDBに登録。
	 * @return 会員登録の結果画面。
	 */
	@RequestMapping("/MemberRegistrationResult")
	String registMember() {

		//会員登録の結果画面。
		return "MemberRegistrationResult";
	}

}
