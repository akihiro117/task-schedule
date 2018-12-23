//LoginEntity.java
//Created by Akihiro Yamada on 2018/12/14.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.entity;

/**
 * ログインするために必要な情報を格納するクラス。
 * @author akihiro
 *
 */
public class LoginEntity {
	private String mailAddress;

	private String password;

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
