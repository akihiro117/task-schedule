//DbUserDetails.java
//Created by Akihiro Yamada on 2018/12/30.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.certification;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class DbUserDetails extends User {
	//ユーザ情報。
	private final Account account;

	public DbUserDetails(Account account,
			Collection<GrantedAuthority> authorities) {

		super(account.getMailAddress(), account.getPassword(),
				true, true, true, true, authorities);

		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

}
