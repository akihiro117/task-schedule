//LoginController.java
//Created by Akihiro Yamada on 2018/12/09.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	/**
	 * ログインフォーム に遷移する。
	 */
	@RequestMapping("/login")
	public String showLoginForm(Model model) {

		//ログイン画面へ遷移。
		return "LoginForm";
	}

	/**
	 * ログイン機能を提供する。
	 * ログインフォームに入力された情報が登録済みかチェックし、
	 * 登録済みならホーム画面へ、未登録ならログインフォーム に遷移する。
	 * @param loginForm ログインフォーム に入力されたデータ。
	 * @return 次の遷移先。
	 */
	@RequestMapping("/")
	public String login(Model model) {

		//アプリケーションのホーム画面に遷移。
		return "Home";
	}
}
