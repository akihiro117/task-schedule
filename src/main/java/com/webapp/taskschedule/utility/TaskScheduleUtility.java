//TaskScheduleUtility.java
//Created by Akihiro Yamada on 2019/2/2.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.utility;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.webapp.taskschedule.certification.DbUserDetails;

public class TaskScheduleUtility {

    /**
     * ログインユーザのメールアドレスを取得する。
     * @return ログインユーザのメールアドレス。
     */
    public static String obtainUserMailAddress() {
        //SecurityContextHolderから認証情報を取得。
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        String mailAddress = null;
        if (authentication.getPrincipal() instanceof DbUserDetails) {
            //認証済みの場合は、ユーザ情報を取得。
            //認証済みでない場合は、匿名ユーザであることを示す文字列が返る。
            DbUserDetails loginUserDetails = DbUserDetails.class
                    .cast(authentication.getPrincipal());
            mailAddress = loginUserDetails.getAccount().getMailAddress();
        }

        return mailAddress;
    }

}
