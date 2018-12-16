//RegistMemberController.java
//Created by Akihiro Yamada on 2018/12/16.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.entity;

/**
 * DBに入れる値を格納するクラス。
 *
 */
public class MemberRegistrationEntity {
	private String name;

	private String eMail;

	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEMail() {
		return eMail;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
