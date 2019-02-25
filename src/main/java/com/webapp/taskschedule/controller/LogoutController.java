//LogoutController.java
//Created by Akihiro Yamada on 2019/2/4.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ログアウト後の画面遷移を提供するクラス。
 *
 */
@Controller
public class LogoutController {

    /**
     * ログアウト成功画面に遷移する。
     */
    @RequestMapping("/logout-success")
    public String showLogoutSuccessPage() {

        return "logout-success";
    }
}
