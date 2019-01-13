//TaskEntity.java
//Created by Akihiro Yamada on 2019/1/11.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.entity;

import java.util.Date;

/**
 * Taskテーブルにinsertする項目を入れるクラス。
 */
public class TaskEntity {

	private int memberId;

	private String taskTitle;

	private String taskDetail;

	//締め切り
	private Date deadLine;

	//作業完了までの所要時間
	private Integer requiredHour;

	private Integer requiredMinute;

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskDetail() {
		return taskDetail;
	}

	public void setTaskDetail(String taskDetail) {
		this.taskDetail = taskDetail;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public Integer getRequiredHour() {
		return requiredHour;
	}

	public void setRequiredHour(Integer requiredHour) {
		this.requiredHour = requiredHour;
	}

	public Integer getRequiredMinute() {
		return requiredMinute;
	}

	public void setRequiredMinute(Integer requiredMinute) {
		this.requiredMinute = requiredMinute;
	}


}
