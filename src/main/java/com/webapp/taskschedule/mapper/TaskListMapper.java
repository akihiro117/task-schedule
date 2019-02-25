//TaskListMapper.java
//Created by Akihiro Yamada on 2019/1/30.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.mapper;

import java.util.List;

import com.webapp.taskschedule.entity.TaskEntity;

/**
 * タスク一覧機能に関するDBへのアクセスを提供する。
 *
 */
public interface TaskListMapper {

    /**
     * Taskテーブルからユーザのタスク情報を取得する。
     */
    public List<TaskEntity> findAllTasks(TaskEntity entity);

}
