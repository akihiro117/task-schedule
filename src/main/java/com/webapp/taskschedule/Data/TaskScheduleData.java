package com.webapp.taskschedule.Data;

/**
 * DBから取得したデータをcontrollerに返すためのクラス。
 *
 */
public class TaskScheduleData {
    //タスクのタイトル
    private String title;

    //タスクの詳細。
    private String detail;

    //タスクの締切日。
    private String deadLine;

    //タスクの所要時。
    private int requiredHour;

    //タスクの所要分。
    private int requiredMinute;

    //タスクのスケジュールの日付。
    private String scheduleDate;

    //タスクのスケジュールの開始時刻。
    private String startTime;

    //タスクのスケジュールの終了時刻。
    private String endTime;

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

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public int getRequiredHour() {
        return requiredHour;
    }

    public void setRequiredHour(int requiredHour) {
        this.requiredHour = requiredHour;
    }

    public int getRequiredMinute() {
        return requiredMinute;
    }

    public void setRequiredMinute(int requiredMinute) {
        this.requiredMinute = requiredMinute;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

}
