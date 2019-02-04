//LogoutController.java
//Created by Akihiro Yamada on 2019/2/4.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	/**
	 * ログアウト成功画面に遷移する。
	 */
	@RequestMapping("/LogoutSuccess")
	public String showLogoutSuccessPage() {

		return "LogoutSuccess";
	}
}
