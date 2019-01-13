//TaskRegistrationForm.java
//Created by Akihiro Yamada on 2019/1/10.
//Copyright (c) 2018. All Rights Reserved.


package com.webapp.taskschedule.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;

public class TaskRegistrationForm {

	@NotBlank(message = "タイトルを入力してください。")
	private String taskTitle;

	@NotBlank(message = "タスクの詳細を入力してください。")
	private String taskDetail;

	//締切年
	@NotBlank(message = "締切日を入力してください。")
	private String deadLineYear;

	//締切月
	@NotBlank(message = "締切日を入力してください。")
	private String deadLineMonth;

	//締切日
	@NotBlank(message = "締切日を入力してください。")
	private String deadLineDay;

	//締切年月日
	private Date deadLine;

	//作業完了までの所要時間
	@NotBlank(message = "所要時間を入力してください。")
	private String requiredHour;

	@NotBlank(message = "所要時間を入力してください。")
	private String requiredMinute;

	private int intRequiredHour;

	private int intRequiredMinute;

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

	public String getDeadLineYear() {
		return deadLineYear;
	}

	public void setDeadLineYear(String deadLineYear) {
		this.deadLineYear = deadLineYear;
	}

	public String getDeadLineMonth() {
		return deadLineMonth;
	}

	public void setDeadLineMonth(String deadLineMonth) {
		this.deadLineMonth = deadLineMonth;
	}

	public String getDeadLineDay() {
		return deadLineDay;
	}

	public void setDeadLineDay(String deadLineDay) {
		this.deadLineDay = deadLineDay;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public String getRequiredHour() {
		return requiredHour;
	}

	public void setRequiredHour(String requiredHour) {
		this.requiredHour = requiredHour;
	}

	public String getRequiredMinute() {
		return requiredMinute;
	}

	public void setRequiredMinute(String requiredMinute) {
		this.requiredMinute = requiredMinute;
	}

	public int getIntRequiredHour() {
		return intRequiredHour;
	}

	public void setIntRequiredHour(int intRequiredHour) {
		this.intRequiredHour = intRequiredHour;
	}

	public int getIntRequiredMinute() {
		return intRequiredMinute;
	}

	public void setIntRequiredMinute(int intRequiredMinute) {
		this.intRequiredMinute = intRequiredMinute;
	}

}
