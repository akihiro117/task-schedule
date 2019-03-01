//TaskRegistrationMapper.java
//Created by Akihiro Yamada on 2019/1/11.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.mapper;

import com.webapp.taskschedule.entity.ScheduleEntity;
import com.webapp.taskschedule.entity.TaskEntity;

/**
 * タスク登録機能に関するDBへのアクセスを提供する。
 *
 */
public interface TaskRegistrationMapper {
    /**
     * タスクをTASKテーブルに登録する。
     */
    //TODO:for updateを付け加える。
    public void insertTask(TaskEntity entity);

    /**
     * 登録したばかりのタスクIDを取得する。
     */
    public int selectNewTaskId();

    /**
     * タスクの作業予定日を登録する。
     */
    public void insertSchedule(ScheduleEntity entity);

}
