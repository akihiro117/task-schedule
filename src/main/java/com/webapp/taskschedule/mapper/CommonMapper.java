//CommonMapper.java
//Created by Akihiro Yamada on 2019/1/11.
//Copyright (c) 2018. All Rights Reserved.


package com.webapp.taskschedule.mapper;

import com.webapp.taskschedule.entity.MemberEntity;

public interface CommonMapper {

	/**
	 * 会員IDを取得。
	 */
	public int selectMemberId(MemberEntity entity);
}
