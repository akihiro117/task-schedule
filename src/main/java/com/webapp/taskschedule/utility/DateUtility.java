package com.webapp.taskschedule.utility;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 日付関連のユーティリティを提供する。
 *
 */
public class DateUtility {

    /**
     * 第二引数のフォーマットの第一引数のString型の日付を
     * sql.Date型に変化する。
     * @param strDate 変換対象の日付。
     * @param format 変換対象の日付のフォーマット。
     * @return 成功した場合、sql.Date型の日付。変換に失敗した場合、null。
     */
    public static Date parse(String strDate, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            //厳密モードに設定。
            sdf.setLenient(false);
            java.util.Date date = sdf.parse(strDate);
            return new Date(date.getTime());
        } catch (ParseException e) {
            //正しい日付でない場合。
            return null;
        }
    }
}
