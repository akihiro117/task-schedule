//TaskRegistrationController.java
//Created by Akihiro Yamada on 2019/1/09.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * タスク登録機能を提供するコントローラークラス。
 */

@Controller
public class TaskRegistrationController {

	@RequestMapping("/TaskRegistrationForm")
	String showTaskRegistrationForm() {


		return "TaskRegistrationForm";
	}


}
