//ModifyMemberInfoController.java
//Created by Akihiro Yamada on 2018/2/17.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp.taskschedule.utility.TaskScheduleUtility;

@Controller
public class ModifyMemberInfoController {

    @RequestMapping("member-info")
    public String showMemberInfoPage(Model model) {

        //ログインユーザのメールアドレスを取得してattributeにセットする。
        model.addAttribute("mailAddress",
                TaskScheduleUtility.obtainUserMailAddress());

        return "member-info-confirmation";
    }

}
