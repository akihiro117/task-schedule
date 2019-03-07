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

    /**
     * タスクの登録フォームを表示する。
     * @param model
     * @return タスクの登録フォームのhtml名。
     */
    @RequestMapping("/task-registration-form")
    String showTaskRegistrationForm(Model model) {

        model.addAttribute("source", "main");

        model.addAttribute(new TaskRegistrationForm());

        return "task-registration-form";
    }

    /**
     * タスクを新規登録する。
     * @param model
     * @param taskRegistrationForm タスク情報。
     * @param result バリデーション結果。
     * @return 入力チェックエラーなし->タスク一覧画面、
     * 入力チェックエラー有り->タスク登録フォーム。
     */
    @RequestMapping("/task-registration")
    String registerTask(Model model,
            @Validated @ModelAttribute TaskRegistrationForm taskRegistrationForm,
            BindingResult result) {

        //controllerで追加するエラーメッセージ。
        List<String> errMsgs = new ArrayList<String>();

        //相関項目エラーがあるか否か。
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
     * @return 全て正しい値->true。正しくない値が存在する->false。
     */
    boolean isCorrectFormValue(TaskRegistrationForm taskRegistrationForm,
            List<String> errMsgs) {

        //正しい日付か否かのフラグ。
        boolean correctFormValue = true;

        //締切り日の日付妥当性チェック。
        String deadLine = taskRegistrationForm.getStrDeadLine();
        if (deadLine != null && !deadLine.equals("")) {
            Date parsedDeadLine = DateUtility.parse(deadLine, "yyyy/MM/dd");
            if (parsedDeadLine == null) {
                //日付が正しくない場合。
                errMsgs.add("締切日に正しい日付を入力してください。");
                correctFormValue = false;
            }
        }

        //作業予定日の日付妥当性チェック。
        //日付、開始時刻、終了時刻の全てがnull、または
        //全てがnullでない場合はOK。
        //それ以外は、NG。

        String[] scheduleDateArray = taskRegistrationForm
                .getStrScheduleStartDate();

        String[] scheduleStartTimeArray = taskRegistrationForm
                .getStrScheduleStartTime();

        String[] scheduleEndTimeArray = taskRegistrationForm
                .getStrScheduleEndTime();

        //各配列の長さが異なる場合はいずれかが全てnullなのでエラー。
        if (!(scheduleDateArray.length == scheduleStartTimeArray.length &&
                scheduleDateArray.length == scheduleEndTimeArray.length)) {
            correctFormValue = false;

            //エラーメッセージを追加。
            errMsgs.add("日付が正しく入力されていません。");

            return correctFormValue;
        }

        //作業予定日付か開始時刻か終了時刻の全てがNullまたは
        //全てがNullでない場合はtrue(OK)、いずれかがNullまたは
        //Nullでない場合はfalse(NG)とする。
        boolean allNullOrNotNull = true;

        for (int i = 0; i < scheduleDateArray.length; i++) {
            allNullOrNotNull = false;

            //全てがNullか否か。
            allNullOrNotNull = Arrays
                    .asList(scheduleDateArray[i], scheduleStartTimeArray[i],
                            scheduleEndTimeArray[i])
                    .stream().allMatch(s -> s == null);

            //全てがNullでないか否か。
            allNullOrNotNull = Arrays
                    .asList(scheduleDateArray[i], scheduleStartTimeArray[i],
                            scheduleEndTimeArray[i])
                    .stream().allMatch(s -> s != null);

            if (!allNullOrNotNull) {
                //エラーメッセージを追加。
                errMsgs.add("日付が正しく入力されていません。");
                correctFormValue = false;

                break;
            }
        }

        return correctFormValue;
    }

}
