//TaskRegistrationService.java
//Created by Akihiro Yamada on 2018/12/13.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.taskschedule.certification.DbUserDetails;
import com.webapp.taskschedule.entity.MemberEntity;
import com.webapp.taskschedule.entity.TaskEntity;
import com.webapp.taskschedule.form.TaskRegistrationForm;
import com.webapp.taskschedule.mapper.CommonMapper;
import com.webapp.taskschedule.mapper.TaskRegistrationMapper;
import com.webapp.taskschedule.utility.DateUtility;

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

        //SecurityContextHolderから認証情報を取得。
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        String mailAddress = null;
        if (authentication.getPrincipal() instanceof DbUserDetails) {
            //認証済みの場合は、ユーザ情報を取得。
            //認証済みでない場合は、匿名ユーザであることを示す文字列が返る。
            DbUserDetails loginUserDetails = DbUserDetails.class
                    .cast(authentication.getPrincipal());
            mailAddress = loginUserDetails.getAccount().getMailAddress();
        }

        //IDをmemberテーブルから取得。
        MemberEntity entity = new MemberEntity();
        entity.setEMail(mailAddress);
        int memberId = commonMapper.selectMemberId(entity);

        TaskEntity task = new TaskEntity();
        task.setMemberId(memberId);
        task.setTitle(form.getTaskTitle());
        task.setDetail(form.getTaskDetail());

        //フォームから取得したString型の日付("yyyyMMdd")をsql.Date型に変換して
        //entityに設定する。
        task.setDeadLine(
                DateUtility.parse(form.getStrDeadLine(), "yyyy/MM/dd"));
        //オートボクシングを避けるためにvalueOfを使用する。
        task.setRequiredHour(Integer.valueOf(form.getIntRequiredHour()));
        task.setRequiredMinute(Integer.valueOf(form.getIntRequiredMinute()));

        taskRegistrationMapper.insertTask(task);
    }

}
