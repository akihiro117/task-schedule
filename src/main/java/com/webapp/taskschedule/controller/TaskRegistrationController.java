//TaskRegistrationController.java
//Created by Akihiro Yamada on 2019/1/09.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp.taskschedule.form.TaskRegistrationForm;
import com.webapp.taskschedule.service.TaskRegistrationService;

/**
 * タスク登録機能を提供するコントローラークラス。
 */

@Controller
public class TaskRegistrationController {

	@Autowired
	private TaskRegistrationService taskRegistrationService;

	@RequestMapping("/TaskRegistrationForm")
	String showTaskRegistrationForm(Model model) {

		model.addAttribute(new TaskRegistrationForm());

		return "TaskRegistrationForm";
	}

	@RequestMapping("/TaskRegistration")
	String registerTask(Model model, @ModelAttribute TaskRegistrationForm taskRegistrationForm) {

		boolean hasUserDefinedErr = false;

		List<String> errMsgs = new ArrayList<String>();

		String strDate = taskRegistrationForm.getDeadLineYear() + "-" +
						 taskRegistrationForm.getDeadLineMonth() + "-" +
						 taskRegistrationForm.getDeadLineDay();

		Date deadLine = converStrToDate(strDate, "yyyy-MM-dd");

		if (deadLine == null) {
			errMsgs.add("正しい日付を入力してください。");
			hasUserDefinedErr = true;

		} else {
			taskRegistrationForm.setDeadLine(deadLine);
		}

		Integer requiredHour = convertStrToInt(taskRegistrationForm.getRequiredHour());

		if (requiredHour == null) {
			errMsgs.add("時間を数値で入力してください。");

			hasUserDefinedErr = true;
		} else {
			taskRegistrationForm.setIntRequiredHour(requiredHour);
		}

		Integer requiredMinute = convertStrToInt(taskRegistrationForm.getRequiredHour());

		if (requiredMinute == null) {
			errMsgs.add("分を数値で入力してください。");

			hasUserDefinedErr = true;
		} else if (requiredMinute >= 60 || requiredMinute < 0) {
			errMsgs.add("正しい分を入力してください。");
			hasUserDefinedErr = true;
		} else {
			taskRegistrationForm.setIntRequiredMinute(requiredMinute);
		}

		if (hasUserDefinedErr) {
			return "TaskRegistrationForm";
		}

		taskRegistrationService.registerTask(taskRegistrationForm);

		return "TaskList";
	}

	Date converStrToDate(String str, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);

		try {
			dateFormat.setLenient(false);

			return dateFormat.parse(str);

		} catch (ParseException e) {
			return null;
		}

	}

	Integer convertStrToInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return null;
		}
	}

}
