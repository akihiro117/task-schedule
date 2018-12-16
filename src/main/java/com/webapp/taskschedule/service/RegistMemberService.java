//RegistMemberController.java
//Created by Akihiro Yamada on 2018/12/13.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.taskschedule.entity.MemberRegistrationEntity;
import com.webapp.taskschedule.mapper.RegistMemberMapper;

@Service
@Transactional
public class RegistMemberService {

	@Autowired
	RegistMemberMapper registMemberMapper;

	/**
	 * 会員情報をDBに登録。
	 */
	public void registMember(MemberRegistrationEntity entity) {

		registMemberMapper.insertMemberInfo(entity);


	}
}
