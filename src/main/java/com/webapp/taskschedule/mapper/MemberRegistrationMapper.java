//MemberRegistrationMapper.java
//Created by Akihiro Yamada on 2018/12/14.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.mapper;

import com.webapp.taskschedule.entity.MemberRegistrationEntity;

public interface MemberRegistrationMapper {
	/**
	 * 会員情報をDBにinsertする。
	 */
	public void insertMemberInfo(MemberRegistrationEntity entity);
}
