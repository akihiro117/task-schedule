//LoginController.java
//Created by Akihiro Yamada on 2018/12/09.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp.taskschedule.Data.TaskScheduleData;
import com.webapp.taskschedule.service.TodaysTaskListService;

/**
 * ログイン時の画面遷移を提供するクラス。
 *
 */
@Controller
public class LoginController {

    @Autowired
    TodaysTaskListService todaysTaskListService;

    /**
     * ログインフォームに遷移する。
     */
    @RequestMapping("/login")
    public String showLoginForm(Model model) {

        //ログイン画面。
        return "login-form";
    }

    /**
     * メインページに遷移する。
     * ログインが成功した場合、このメソッドが呼び出される。
     */
    @RequestMapping("/")
    public String login(Model model) {
        //今日作業予定のタスクを取得。
        List<TaskScheduleData> outputData = todaysTaskListService
                .obtainTodaysTaskList();

        model.addAttribute("todaysTaskList", outputData);

        //メインページ。
        return "index";
    }
}
