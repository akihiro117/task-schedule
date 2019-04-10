package com.webapp.taskschedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.taskschedule.mapper.TaskDeleteMapper;

/**
 * タスクの削除機能を提供するサービスクラス。
 *
 */
@Service
@Transactional
public class TaskDeleteService {
    @Autowired
    TaskDeleteMapper taskDeleteMapper;

    public void deleteATask(int taskId) {
        // タスクを削除。
        taskDeleteMapper.deleteATask(taskId);
    }
}
