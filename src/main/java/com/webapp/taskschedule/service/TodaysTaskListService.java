package com.webapp.taskschedule.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.taskschedule.DaoData.TaskScheduleInputDaoData;
import com.webapp.taskschedule.DaoData.TaskScheduleOutputDaoData;
import com.webapp.taskschedule.Data.TaskScheduleData;
import com.webapp.taskschedule.entity.MemberEntity;
import com.webapp.taskschedule.mapper.CommonMapper;
import com.webapp.taskschedule.mapper.TaskListMapper;
import com.webapp.taskschedule.utility.TaskScheduleUtility;

@Service
@Transactional
public class TodaysTaskListService {

    @Autowired
    TaskListMapper taskListMapper;

    @Autowired
    CommonMapper commonMapper;

    public List<TaskScheduleData> obtainTodaysTaskList() {
        LocalDate today = LocalDate.now();
        //現在日付。
        String strToday = DateTimeFormatter.ofPattern("yyyyMMdd").format(today);

        //会員ID。
        //int memberId = TaskScheduleUtility.obtainMemberId();
        MemberEntity entity = new MemberEntity();

        //認証情報内のメールアドレスをentityに設定。
        entity.setEMail(TaskScheduleUtility.obtainUserMailAddress());

        //IDをmemberテーブルから取得。
        int memberId = commonMapper.selectMemberId(entity);

        TaskScheduleInputDaoData inputDaoData = new TaskScheduleInputDaoData();
        inputDaoData.setMemberId(memberId);
        inputDaoData.setToday(strToday);

        List<TaskScheduleOutputDaoData> todaysTaskList = taskListMapper
                .findTodaysTasks(inputDaoData);

        List<TaskScheduleData> dataList = new ArrayList<>();

        for (TaskScheduleOutputDaoData tmp : todaysTaskList) {
            TaskScheduleData data = new TaskScheduleData();
            data.setTitle(tmp.getTitle());
            data.setDetail(tmp.getDetail());
            data.setRequiredHour(tmp.getRequiredHour());
            data.setRequiredMinute(tmp.getRequiredMinute());

            data.setScheduleDate(DateTimeFormatter.ofPattern("yyyy/MM/dd")
                    .format(tmp.getStartDateTime().toLocalDateTime()));

            data.setStartTime(DateTimeFormatter.ofPattern("HH:mm")
                    .format(tmp.getStartDateTime().toLocalDateTime()));

            data.setEndTime(DateTimeFormatter.ofPattern("HH:mm")
                    .format(tmp.getEndDateTime().toLocalDateTime()));

            dataList.add(data);
        }

        if (dataList.isEmpty()) {
            //今日のタスクがなかった場合はnullを返す。
            return null;
        } else {
            return dataList;
        }

    }
}
