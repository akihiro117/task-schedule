//LoginController.java
//Created by Akihiro Yamada on 2018/12/09.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ログイン時の画面遷移を提供するクラス。
 *
 */
@Controller
public class LoginController {

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

        //メインページ。
        return "index";
    }
}
