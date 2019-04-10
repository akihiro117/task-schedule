package com.webapp.taskschedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.taskschedule.service.TaskDeleteService;

/**
 * タスク削除機能を提供するコントローラークラス。
 *
 */
@Controller
public class TaskDeleteController {
    @Autowired
    TaskDeleteService taskDeleteService;

    /**
     * タスクを削除。
     * @return タスク一覧画面のhtml名。
     */
    @RequestMapping("/delete-task")
    String deleteATask(@RequestParam String taskId) {
        // タスクを削除。
        taskDeleteService.deleteATask(Integer.parseInt(taskId));

        // 削除の一覧を取得して表示。
        return "redirect:/task-list";
    }
}
