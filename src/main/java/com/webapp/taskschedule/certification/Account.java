//Account.java
//Created by Akihiro Yamada on 2018/12/30.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.certification;

/**
 * ログインに必要な会員情報を格納するクラス。
 * @author Akihiro Yamada
 *
 */
public class Account {

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
