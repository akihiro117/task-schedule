//DbUserDetailsService.java
//Created by Akihiro Yamada on 2018/12/30.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.taskschedule.certification.Account;
import com.webapp.taskschedule.certification.DbUserDetails;
import com.webapp.taskschedule.mapper.LoginMapper;

/**
 * ユーザ認証を提供する。
 *
 */
@Service
public class DbUserDetailsService implements UserDetailsService {

    @Autowired
    LoginMapper loginMapper;

    /**
     * 認証の際にユーザ情報をmemberテーブルから取得する。
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String mailAddress)
            throws UsernameNotFoundException {
        //DBからユーザ情報を取得。
        Account account = Optional.ofNullable(loginMapper.findOne(mailAddress))
                .orElseThrow(
                        () -> new UsernameNotFoundException("User not found."));

        return new DbUserDetails(account, getAuthorities(account));
    }

    /**
     * 認証が通った時にこのユーザに与える権限の範囲を設定する。
     * @param account DBから取得したユーザ情報。
     * @return 権限の範囲のリスト。
     */
    private Collection<GrantedAuthority> getAuthorities(Account account) {
        //認可が通った時にこのユーザに与える権限の範囲を設定する。
        return AuthorityUtils.createAuthorityList("ROLE_USER");
    }

}
