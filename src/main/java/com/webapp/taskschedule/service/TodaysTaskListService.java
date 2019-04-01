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

/**
 * 今日のタスクを取得するためのサービスクラス。
 *
 */
@Service
@Transactional
public class TodaysTaskListService {

    @Autowired
    TaskListMapper taskListMapper;

    @Autowired
    CommonMapper commonMapper;

    /**
     * 今日のタスクを取得。
     * @return 今日のタスクのリスト。
     */
    public List<TaskScheduleData> obtainTodaysTaskList() {
        LocalDate today = LocalDate.now();
        //現在日付。
        String strToday = DateTimeFormatter.ofPattern("yyyyMMdd").format(today);

        //会員ID。
        MemberEntity entity = new MemberEntity();

        //認証情報内のメールアドレスをentityに設定。
        entity.setEMail(TaskScheduleUtility.obtainUserMailAddress());

        //IDをmemberテーブルから取得。
        int memberId = commonMapper.selectMemberId(entity);

        TaskScheduleInputDaoData inputDaoData = new TaskScheduleInputDaoData();
        inputDaoData.setMemberId(memberId);
        inputDaoData.setToday(strToday);

        //DBから取得した今日のタスク。
        List<TaskScheduleOutputDaoData> todaysTaskList = taskListMapper
                .findTodaysTasks(inputDaoData);

        //戻り値を入れる。
        List<TaskScheduleData> dataList = new ArrayList<>();

        //DBから取得したデータを戻り値用に詰め替える。
        for (TaskScheduleOutputDaoData tmp : todaysTaskList) {
            TaskScheduleData data = new TaskScheduleData();
            data.setTitle(tmp.getTitle());

            //スケジュール詳細。
            data.setDetail(tmp.getDetail());

            //所要時間(時)。
            data.setRequiredHour(tmp.getRequiredHour());

            //所要時間(分)。
            data.setRequiredMinute(tmp.getRequiredMinute());

            //Timestamp型の作業予定日をLocalDateTime型に変換してString型に変換する。
            data.setScheduleDate(DateTimeFormatter.ofPattern("yyyy/MM/dd")
                    .format(tmp.getStartDateTime().toLocalDateTime()));

            //Timestamp型の作業開始予定時刻をLocalDateTime型に変換してString型に変換する。
            data.setStartTime(DateTimeFormatter.ofPattern("HH:mm")
                    .format(tmp.getStartDateTime().toLocalDateTime()));

            //Timestamp型の作業終了予定時刻をLocalDateTime型に変換してString型に変換する。
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
