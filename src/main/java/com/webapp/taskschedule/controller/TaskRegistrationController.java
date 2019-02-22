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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

    @RequestMapping("/task-registration-form")
    String showTaskRegistrationForm(Model model) {

        model.addAttribute("source", "main");

        model.addAttribute(new TaskRegistrationForm());

        return "task-registration-form";
    }

    @RequestMapping("/TaskRegistration")
    String registerTask(Model model,
            @Validated @ModelAttribute TaskRegistrationForm taskRegistrationForm,
            BindingResult result) {

        boolean hasUserDefinedErr = false;

        List<String> errMsgs = new ArrayList<String>();

        Integer requiredHour = convertStrToInt(
                taskRegistrationForm.getRequiredHour());

        if (requiredHour == null) {
            errMsgs.add("時間を数値で入力してください。");

            hasUserDefinedErr = true;
        } else {
            taskRegistrationForm.setIntRequiredHour(requiredHour);
        }

        Integer requiredMinute = convertStrToInt(
                taskRegistrationForm.getRequiredMinute());

        if (requiredMinute == null) {
            errMsgs.add("分を数値で入力してください。");

            hasUserDefinedErr = true;
        } else if (requiredMinute >= 60 || requiredMinute < 0) {
            errMsgs.add("正しい分を入力してください。");
            hasUserDefinedErr = true;
        } else {
            taskRegistrationForm.setIntRequiredMinute(requiredMinute);
        }

        if (hasUserDefinedErr || result.hasErrors()) {
            model.addAttribute("errMsgs", errMsgs);

            return "task-registration-form";
        }

        taskRegistrationService.registerTask(taskRegistrationForm);

        return "redirect:/TaskList";
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

    /**
     * 引数が一つでもnullか空文字だったら、falseを返す。
     * @param strings
     * @return
     */
    boolean isNullOrEmpty(String... strings) {

        for (String str : strings) {
            if (str == null || str.equals("")) {
                return true;
            }
        }
        return false;
    }

}
