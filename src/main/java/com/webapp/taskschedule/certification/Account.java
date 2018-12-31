//Account.java
//Created by Akihiro Yamada on 2018/12/30.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.certification;

/**
 * 会員情報を格納するクラス。
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

	//adminも権限に追加する時は、
	//メンバ変数にadminを追加し、
	//このメソッドでadminを返すようにする。
	public boolean isAdmin() {
		return false;
	}

}
