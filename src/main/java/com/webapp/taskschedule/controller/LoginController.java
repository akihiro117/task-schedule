//LoginController.java
//Created by Akihiro Yamada on 2018/12/09.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp.taskschedule.entity.LoginEntity;
import com.webapp.taskschedule.form.LoginForm;
import com.webapp.taskschedule.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	public LoginService loginService;

	@RequestMapping("/")
	String showLoginForm(Model model) {

		model.addAttribute(new LoginForm());

		//ログイン画面へ遷移。
		return "LoginForm";
	}

	@RequestMapping("/login")
	String login(@ModelAttribute LoginForm loginForm) {

		LoginEntity loginEntity = new LoginEntity();
		loginEntity.setMailAddress(loginForm.getMailAddress());
		loginEntity.setPassword(loginForm.getPassword());
		boolean isMember = loginService.checkLogin(loginEntity);

		if (isMember) {
		//アプリケーションのホーム画面に遷移。
		return "Home";
		} else {
			return "LoginForm";
		}
	}

}
