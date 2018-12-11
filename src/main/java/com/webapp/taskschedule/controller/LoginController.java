//LoginController.java
//Created by Akihiro Yamada on 2018/12/09.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/")
	String showLoginForm() {

		//ログイン画面へ遷移。
		return "LoginForm";
	}

}
