//TaskListService.java
//Created by Akihiro Yamada on 2019/1/30.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.taskschedule.entity.MemberEntity;
import com.webapp.taskschedule.entity.TaskEntity;
import com.webapp.taskschedule.mapper.CommonMapper;
import com.webapp.taskschedule.mapper.TaskListMapper;
import com.webapp.taskschedule.outputdata.TaskListOutputData;
import com.webapp.taskschedule.utility.TaskScheduleUtility;

@Service
@Transactional
public class TaskListService {

	@Autowired
	TaskListMapper taskListMapper;

	@Autowired
	CommonMapper commonMapper;

	/**
	 * ユーザの全タスク情報を取得。
	 * @return htmlに表示するタスク情報。
	 */
	public List<TaskListOutputData> findAllTask() {

		//TODO:nullで返ってきた場合の処理を実装。
		//ログインユーザのメールアドレスをSecurityContextHolderを通して取得。
		String mailAddress = TaskScheduleUtility.obtainUserMailAddress();

		//IDをmemberテーブルから取得。
		MemberEntity memberEntity = new MemberEntity();
		memberEntity.setEMail(mailAddress);
		int memberId = commonMapper.selectMemberId(memberEntity);

		//mapperに渡す引数。
		TaskEntity taskEntity = new TaskEntity();

		taskEntity.setMemberId(memberId);

		List<TaskEntity> taskList = taskListMapper.findAllTasks(taskEntity);

		List<TaskListOutputData> outputData = new ArrayList<TaskListOutputData>();

		//TODO:deadLine順に表示するようする。
		//DBから取得した項目をoutputDataに入れる。
		for (TaskEntity tmp : taskList) {
			TaskListOutputData tmpOutputData = new TaskListOutputData();
			//tmpのフィールドをtmpOutputDataにコピー。
			BeanUtils.copyProperties(tmp, tmpOutputData);

			outputData.add(tmpOutputData);
		}

		return outputData;
	}

}
