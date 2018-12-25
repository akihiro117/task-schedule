//WebSecurityConfig.java
//Created by Akihiro Yamada on 2018/12/24.
//Copyright (c) 2018. All Rights Reserved.


package com.webapp.taskschedule.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//ログインページを指定。
		//ログインページへのアクセスは全員許可する。
		//TODO:csrf対策を有効にする。
		http.csrf().disable().formLogin()
				.loginPage("/")
				.permitAll();
		//TODO:csrf対策を有効にする。
		http.csrf().disable().authorizeRequests()
				.antMatchers("/MemberRegistrationConfirm").permitAll()
				.antMatchers("/RegistForm").permitAll()
				.antMatchers("/MemberRegistrationResult").permitAll()
				.anyRequest().authenticated();
		//http.csrf().ignoringAntMatchers("/MemberRegistrationConfirm");
	}

}
