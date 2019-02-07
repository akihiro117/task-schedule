//MemberRegistrationService.java
//Created by Akihiro Yamada on 2018/12/13.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.taskschedule.entity.MemberEntity;
import com.webapp.taskschedule.mapper.MemberRegistrationMapper;

@Service
@Transactional
public class MemberRegistrationService {

	@Autowired
	MemberRegistrationMapper memberRegistrationMapper;

	@Autowired
	PasswordEncoder passwordEncoder;


	/**
	 * 会員情報をDBに登録。
	 */
	public void registerMember(MemberEntity entity) {

		entity.setPassword(passwordEncoder.encode(entity.getPassword()));

		memberRegistrationMapper.insertMemberInfo(entity);
	}
}
