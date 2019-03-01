//TaskRegistrationForm.java
//Created by Akihiro Yamada on 2019/1/10.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * タスク登録フォームに入力された項目を入れるクラス。
 * 単項目入力チェックを提供する。
 *
 */
public class TaskRegistrationForm {

    //タスクのタイトル。
    @NotBlank(message = "タイトルを入力してください。")
    @Size(max = 50, message = "タイトルの文字数が最大文字数50文字を超えています。")
    private String taskTitle;

    //タスクの詳細内容
    @Size(max = 500, message = "内容の文字数が最大文字数500文字を超えています。")
    private String taskDetail;

    //締切年月日
    private String strDeadLine;

    //作業完了までの所要時間(時)
    //文字列で受け取るため、範囲チェックはcontrollerで行う。
    //数値への変換はserviceクラスで行う。
    @Pattern(regexp = "[0-9]*", message = "正しい時を入力してください。")
    private String requiredHour;

    //作業完了までの所要時間(分)
    @Pattern(regexp = "^[0-5]?[0-9]?$", message = "正しい分を入力してください。")
    private String requiredMinute;

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
