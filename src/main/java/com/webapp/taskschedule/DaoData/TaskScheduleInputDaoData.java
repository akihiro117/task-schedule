package com.webapp.taskschedule.DaoData;

public class TaskScheduleInputDaoData {
    //会員ID。
    private int memberId;

    //今日の日付("yyyyMMdd")。
    private String today;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

}
