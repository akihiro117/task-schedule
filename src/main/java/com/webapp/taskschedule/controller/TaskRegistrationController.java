//TaskRegistrationController.java
//Created by Akihiro Yamada on 2019/1/09.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.webapp.taskschedule.utility.DateUtility;

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

        //controllerで追加するエラーメッセージ。
        List<String> errMsgs = new ArrayList<String>();
        boolean errors = !isCorrectFormValue(taskRegistrationForm, errMsgs);

        if (errors || result.hasErrors()) {
            model.addAttribute("errMsgs", errMsgs);

            return "task-registration-form";
        }

        taskRegistrationService.registerTask(taskRegistrationForm);

        return "redirect:/task-list";
    }

    /**
     * formクラスのアノテーションでチェックできない入力チェックを行う。
     * @param taskRegistrationForm タスク登録フォームに入力された値。
     * @return 正しい値->true。正しくない値->false。
     */
    boolean isCorrectFormValue(TaskRegistrationForm taskRegistrationForm,
            List<String> errMsgs) {

        //正しい日付か否かのフラグ。
        boolean correctFormValue = true;

        //締切り日の日付妥当性チェック。
        Date pasedDeadLine = DateUtility
                .parse(taskRegistrationForm.getStrDeadLine(), "yyyy/MM/dd");
        if (pasedDeadLine == null) {
            //日付が正しくない場合。
            errMsgs.add("締切日に正しい日付を入力してください。");
            correctFormValue = false;
        }

        //作業予定日の日付妥当性チェック。
        String[] scheduleDateArray = taskRegistrationForm
                .getStrScheduleStartDate();

        //入力された日付の内、一つでもnullがあれば正しくない日付と判定。
        correctFormValue = Arrays.stream(scheduleDateArray)
                .allMatch(s -> DateUtility.parse(s, "yyyy/MM/dd") != null);

        //TODO:エラーメッセージを追加。

        return correctFormValue;

    }

}
