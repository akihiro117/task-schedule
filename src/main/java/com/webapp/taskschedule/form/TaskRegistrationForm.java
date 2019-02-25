//TaskRegistrationForm.java
//Created by Akihiro Yamada on 2019/1/10.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.form;

import javax.validation.constraints.NotBlank;

/**
 * タスク登録フォームに入力された項目を入れるクラス。
 * 単項目入力チェックを提供する。
 *
 */
public class TaskRegistrationForm {

    @NotBlank(message = "タイトルを入力してください。")
    private String taskTitle;

    @NotBlank(message = "タスクの詳細を入力してください。")
    private String taskDetail;

    //締切年月日
    @NotBlank(message = "締切日を入力してください。")
    private String strDeadLine;

    //作業完了までの所要時間
    @NotBlank(message = "所要時間を入力してください。")
    private String requiredHour;

    @NotBlank(message = "所要時間を入力してください。")
    private String requiredMinute;

    private int intRequiredHour;

    private int intRequiredMinute;

    //タスクの作業予定日。
    private String[] strScheduleStartDate;

    //タスクの作業予定開始時刻。
    private String[] strScheduleStartTime;

    //タスクの作業予定終了時刻。
    private String[] strScheduleEndTime;

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

    public String getStrDeadLine() {
        return strDeadLine;
    }

    public void setStrDeadLine(String strDeadLine) {
        this.strDeadLine = strDeadLine;
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

    public String[] getStrScheduleStartDate() {
        return strScheduleStartDate;
    }

    public void setStrScheduleStartDate(String[] strScheduleStartDate) {
        this.strScheduleStartDate = strScheduleStartDate;
    }

    public String[] getStrScheduleStartTime() {
        return strScheduleStartTime;
    }

    public void setStrScheduleStartTime(String[] strScheduleStartTime) {
        this.strScheduleStartTime = strScheduleStartTime;
    }

    public String[] getStrScheduleEndTime() {
        return strScheduleEndTime;
    }

    public void setStrScheduleEndTime(String[] strScheduleEndTime) {
        this.strScheduleEndTime = strScheduleEndTime;
    }

}
