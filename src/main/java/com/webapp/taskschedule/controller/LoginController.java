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

	/**
	 * ログインフォーム に遷移する。
	 */
	@RequestMapping("/")
	public String showLoginForm(Model model) {

		model.addAttribute(new LoginForm());

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
	@RequestMapping("/login")
	public String login(@ModelAttribute LoginForm loginForm, Model model) {

		//mapperに渡すパラメータを入れるためのオブジェクト。
		LoginEntity loginEntity = new LoginEntity();
		loginEntity.setMailAddress(loginForm.getMailAddress());
		loginEntity.setPassword(loginForm.getPassword());

		//ログインフォーム に入力されたデータの件数を取得。
		boolean isMember = loginService.checkLogin(loginEntity);

		if (isMember) {
			//アプリケーションのホーム画面に遷移。
			return "Home";
		} else {
			//ログインに失敗した場合にログインフォーム に表示するメッセージ。
			model.addAttribute("errMsg", "メールアドレスもしくはパスワードが間違っています。");

			//存在しない場合は、ログインフォーム に戻る。
			return "LoginForm";
		}
	}
}
