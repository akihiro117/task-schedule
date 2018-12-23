//LoginService.java
//Created by Akihiro Yamada on 2018/12/23.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.taskschedule.entity.LoginEntity;
import com.webapp.taskschedule.mapper.LoginMapper;

@Service
@Transactional
public class LoginService {

	@Autowired LoginMapper loginMapper;

	/**
	 * ログインフォーム に入力された情報がDBに存在するか確認する。
	 */
	public boolean checkLogin(LoginEntity loginEntity) {


		//検索結果。
		int numMemberInfo = loginMapper.selectNumMemberInfo(loginEntity);

		if (numMemberInfo != 1) {
			return false;
		} else {
			return true;
		}

	}
}
