//TaskListOutputdata.java
//Created by Akihiro Yamada on 2019/1/30.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.outputdata;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * htmlに返すタスク一覧データを格納する。
 *
 */
public class TaskListOutputData {
    // タスクのID。
    private String taskId;

    //タスクのタイトル。
    private String title;

    //タスクの詳細。
    private String detail;

    //締め切り(DBから取得した値を保持する)
    private Date deadLine;

    //締め切り(出力する値を保持する)
    private String strDeadLine;

    //作業完了までの所要時間。
    private Integer requiredHour;

    //作業完了までの所要分。
    private Integer requiredMinute;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
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

        //想定外の動作を避けるために、
        //Date型のdeadLineを設定する段階で
        //deadLineを指定した形式に変換してstrDeadLineに代入する。
        //外部からのメンバ変数の操作を出来るだけ避ける。
        this.strDeadLine = new SimpleDateFormat("yyyy/MM/dd").format(deadLine);
    }

    public String getStrDeadLine() {
        return strDeadLine;
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
