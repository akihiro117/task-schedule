package com.webapp.taskschedule.entity;

import java.sql.Timestamp;

/**
 * SCHEDULEテーブルのentityクラス。
 *
 */
public class ScheduleEntity {
    //対応するタスクのID。
    private int taskId;

    //作業予定開始日時。
    private Timestamp startDateTime;

    //作業予定終了日時。
    private Timestamp endDateTime;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
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
