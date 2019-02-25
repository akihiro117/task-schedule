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

    @RequestMapping("/task-registration")
    String registerTask(Model model,
            @Validated @ModelAttribute TaskRegistrationForm taskRegistrationForm,
            BindingResult result) {

        boolean hasUserDefinedErr = false;

        List<String> errMsgs = new ArrayList<String>();

        //作業所要時間(時)
        Integer requiredHour = convertStrToInt(
                taskRegistrationForm.getRequiredHour());

        if (requiredHour == null) {
            errMsgs.add("時間を数値で入力してください。");

            hasUserDefinedErr = true;
        } else {
            //アンボクシングを避けるためにintValue()で明示的に変換する。
            taskRegistrationForm
                    .setIntRequiredHour(requiredHour.intValue());
        }

        //作業所要時間(分)
        Integer requiredMinute = convertStrToInt(
                taskRegistrationForm.getRequiredMinute());

        if (requiredMinute == null) {
            errMsgs.add("分を数値で入力してください。");

            hasUserDefinedErr = true;
        } else if (requiredMinute.intValue() >= 60
                || requiredMinute.intValue() < 0) {
            errMsgs.add("正しい分を入力してください。");
            hasUserDefinedErr = true;
        } else {
            taskRegistrationForm
                    .setIntRequiredMinute(requiredMinute.intValue());
        }

        if (hasUserDefinedErr || result.hasErrors()) {
            model.addAttribute("errMsgs", errMsgs);

            return "task-registration-form";
        }

        taskRegistrationService.registerTask(taskRegistrationForm);

        return "redirect:/task-list";
    }

    /**
     * 第二引数のフォーマットのString型の日付を
     * Date型に変換する。
     * @param str 変換対象の日付。
     * @param format 変換対象のフォーマット。
     * @return 変換対象の日付が日付の形式の場合は、Date型の日付。
     * 日付の形式でない場合はnullを返す。
     */
    Date converStrToDate(String str, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);

        try {
            //厳密モードを設定。
            dateFormat.setLenient(false);

            return dateFormat.parse(str);
        } catch (ParseException e) {
            //日付の形式でない場合はnullを返す。
            return null;
        }
    }

    /**
     * String型をint型に変換する。
     * @param str 変換対象。
     * @return 変換できる場合、数値。
     * 変換できない場合、null。
     */
    Integer convertStrToInt(String str) {
        try {
            //intからIntegerへのオートボクシングを避けるため、
            //parseInt()でなくvalueOf()を使用する。
            return Integer.valueOf(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * null、空文字判定を行う。
     * @param strings 判定対象の文字列。
     * @return 引数が一つでもnullか空文字だったら、false。
     * 全てnullでも空文字でもなければtrue。
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
