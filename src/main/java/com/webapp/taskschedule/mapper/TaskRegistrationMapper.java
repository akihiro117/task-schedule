//TaskRegistrationMapper.java
//Created by Akihiro Yamada on 2019/1/11.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.mapper;

import com.webapp.taskschedule.entity.TaskEntity;

/**
 * タスク登録機能に関するDBへのアクセスを提供する。
 *
 */
public interface TaskRegistrationMapper {
    /**
     * タスクをTASKテーブルに登録する。
     */
    public void insertTask(TaskEntity entity);

}
