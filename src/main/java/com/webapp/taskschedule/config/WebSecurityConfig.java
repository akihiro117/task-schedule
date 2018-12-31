//WebSecurityConfig.java
//Created by Akihiro Yamada on 2018/12/24.
//Copyright (c) 2018. All Rights Reserved.


package com.webapp.taskschedule.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//ログインページを指定。
		//ログインページへのアクセスは全員許可する。
		//TODO:csrf対策を有効にする。
		http.csrf().disable().formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/authenticate")
				.usernameParameter("mailAddress")
				.passwordParameter("password")
				.permitAll();
		//TODO:csrf対策を有効にする。
		http.csrf().disable().authorizeRequests()
				.antMatchers("/MemberRegistrationConfirm").permitAll()
				.antMatchers("/RegistForm").permitAll()
				.antMatchers("/MemberRegistrationResult").permitAll()
				.anyRequest().authenticated();
		//http.csrf().ignoringAntMatchers("/MemberRegistrationConfirm");
	}

	@Autowired
	void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
