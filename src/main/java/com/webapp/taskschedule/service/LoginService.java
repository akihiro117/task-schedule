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

	@Autowired
	private LoginMapper loginMapper;



	/**
	 * ログインフォーム に入力されたメールアドレスと
	 * パスワードの組が正しいか確認する。
	 * @param loginEntity ログインフォーム に入力された
	 * メールアドレスとパスワードの組が入ったEntityクラス。
	 * return 正しい->true。正しくない->false。
	 */
	public boolean checkLogin(LoginEntity loginEntity) {

		//検索結果。
		String encodedPassword = loginMapper.selectPassword(loginEntity);

		return true;
	}
}
