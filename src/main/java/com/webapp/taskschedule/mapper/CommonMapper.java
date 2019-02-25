//CommonMapper.java
//Created by Akihiro Yamada on 2019/1/11.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.mapper;

import com.webapp.taskschedule.entity.MemberEntity;

/**
 * 各機能共通で利用するDBアクセスを提供する。
 *
 */
public interface CommonMapper {

    /**
     * 会員IDを取得。
     */
    public int selectMemberId(MemberEntity entity);
}
