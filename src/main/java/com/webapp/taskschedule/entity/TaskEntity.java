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

	private String title;

	private String detail;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
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
