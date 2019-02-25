//ModifyMemberInfoController.java
//Created by Akihiro Yamada on 2018/2/17.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp.taskschedule.utility.TaskScheduleUtility;

/**
 * 会員情報の変更機能を提供するクラス。
 *
 */
@Controller
public class ModifyMemberInfoController {

    /**
     * 会員情報を表示する。
     * @return 会員情報画面。
     */
    @RequestMapping("member-info")
    public String showMemberInfoPage(Model model) {

        //ログインユーザのメールアドレスを取得してattributeにセットする。
        model.addAttribute("mailAddress",
                TaskScheduleUtility.obtainUserMailAddress());

        return "member-info-confirmation";
    }

}
