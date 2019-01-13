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
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String mailAddress = null;
		if (authentication.getPrincipal() instanceof DbUserDetails) {
			//認証済みの場合は、ユーザ情報を取得。
			//認証済みでない場合は、匿名ユーザであることを示す文字列が返る。
			DbUserDetails loginUserDetails = DbUserDetails.class.cast(authentication.getPrincipal());
			mailAddress = loginUserDetails.getAccount().getMailAddress();
		}

		//IDをmemberテーブルから取得。
		MemberEntity entity = new MemberEntity();
		entity.setEMail(mailAddress);
		int memberId = commonMapper.selectMemberId(entity);

		TaskEntity task = new TaskEntity();
		task.setMemberId(memberId);
		task.setTaskTitle(form.getTaskTitle());
		task.setTaskDetail(form.getTaskDetail());
		task.setDeadLine(form.getDeadLine());
		task.setRequiredHour(form.getIntRequiredHour());
		task.setRequiredMinute(form.getIntRequiredMinute());

		taskRegistrationMapper.insertTask(task);

	}

}
