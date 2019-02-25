//TaskListController.java
//Created by Akihiro Yamada on 2019/1/30.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp.taskschedule.outputdata.TaskListOutputData;
import com.webapp.taskschedule.service.TaskListService;

/**
 * タスク一覧機能を提供するクラス。
 *
 */
@Controller
public class TaskListController {

    @Autowired
    TaskListService taskListService;

    /**
     * タスク一覧を表示。
     * @return タスク一覧画面のhtml名。
     */
    @RequestMapping("/task-list")
    String showTaskList(Model model) {

        //ユーザの全タスクを取得。
        List<TaskListOutputData> allTaskList = taskListService.findAllTask();

        model.addAttribute("allTaskList", allTaskList);

        return "task-list";
    }

}
