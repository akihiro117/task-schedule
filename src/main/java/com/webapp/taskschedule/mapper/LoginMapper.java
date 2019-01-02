//LoginMapper.java
//Created by Akihiro Yamada on 2018/12/23.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.mapper;

import com.webapp.taskschedule.certification.Account;

public interface LoginMapper {

	public Account findOne(String mailAddress);
}
