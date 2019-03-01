//TaskRegistrationService.java
//Created by Akihiro Yamada on 2018/12/13.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.taskschedule.entity.MemberEntity;
import com.webapp.taskschedule.entity.TaskEntity;
import com.webapp.taskschedule.form.TaskRegistrationForm;
import com.webapp.taskschedule.mapper.CommonMapper;
import com.webapp.taskschedule.mapper.TaskRegistrationMapper;
import com.webapp.taskschedule.utility.DateUtility;
import com.webapp.taskschedule.utility.TaskScheduleUtility;

/**
 * タスク登録を提供するサービスクラス。
 *
 */
@Service
@Transactional
public class TaskRegistrationService {

    @Autowired
    TaskRegistrationMapper taskRegistrationMapper;

    @Autowired
    CommonMapper commonMapper;

    /**
     * タスクをDBに登録。
     */
    public void registerTask(TaskRegistrationForm form) {

        MemberEntity entity = new MemberEntity();
        //認証情報内のメールアドレスをentityに設定。
        entity.setEMail(TaskScheduleUtility.obtainUserMailAddress());
        //IDをmemberテーブルから取得。
        int memberId = commonMapper.selectMemberId(entity);

        TaskEntity task = new TaskEntity();
        task.setMemberId(memberId);
        task.setTitle(form.getTaskTitle());
        task.setDetail(form.getTaskDetail());

        //フォームから取得したString型の日付("yyyyMMdd")をsql.Date型に変換して
        //entityに設定する。
        task.setDeadLine(
                DateUtility.parse(form.getStrDeadLine(), "yyyy/MM/dd"));
        //オートボクシングを避けるためにpaseIntでなくvalueOfを使用する。
        task.setRequiredHour(Integer.valueOf(form.getRequiredHour()));
        task.setRequiredMinute(Integer.valueOf(form.getRequiredMinute()));

        taskRegistrationMapper.insertTask(task);

    }

}
