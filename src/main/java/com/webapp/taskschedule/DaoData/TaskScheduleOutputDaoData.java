package com.webapp.taskschedule.DaoData;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * DBから取得したデータを格納するクラス。
 *
 */
public class TaskScheduleOutputDaoData {
    //タスクのタイトル
    private String title;

    //タスクの詳細。
    private String detail;

    //タスクの締切日。
    private Date deadLine;

    //タスクの所要時。
    private int requiredHour;

    //タスクの所要分。
    private int requiredMinute;

    //タスクのスケジュールの開始日時。
    private Timestamp startDateTime;

    //タスクのスケジュールの終了日時。
    private Timestamp endDateTime;

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

    public Timestamp getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Timestamp startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Timestamp getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Timestamp endDateTime) {
        this.endDateTime = endDateTime;
    }

}
