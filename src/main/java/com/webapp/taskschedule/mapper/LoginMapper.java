//LoginMapper.java
//Created by Akihiro Yamada on 2018/12/23.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.mapper;

import com.webapp.taskschedule.certification.Account;
import com.webapp.taskschedule.entity.LoginEntity;

public interface LoginMapper {

	/**
	 * 入力された会員情報と一致する件数を取得する。
	 * @param ログインフォーム に入力された情報。
	 * @return ログインフォーム に入力された情報の件数。
	 */
	public String selectPassword(LoginEntity loginEntity);

	public Account findOne(String mailAddress);
}
