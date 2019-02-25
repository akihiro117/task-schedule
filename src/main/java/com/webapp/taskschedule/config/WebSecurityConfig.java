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
        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticate")
                .usernameParameter("mailAddress")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .permitAll();

        //認可の情報を設定。
        http.authorizeRequests()
                .antMatchers("/member-registration-confirm").permitAll()
                .antMatchers("/member-registration-form").permitAll()
                .antMatchers("/member-registration-result").permitAll()
                .antMatchers("/css/*").permitAll()
                .antMatchers("task-list", "task-registration-form")
                .hasRole("USER")
                .anyRequest().authenticated();

        //ログアウト機能を有効にし、
        //全てのユーザにログアウト処理のパスと
        //ログアウト後のパスへのアクセス権を付与する。
        http.logout()
                .logoutSuccessUrl("/logout-success")
                .permitAll();
    }

    /**
     * ハッシュ化したパスワードを用いて認証を行う。
     */
    @Autowired
    void configureAuthenticationManager(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    /**
     * パスワードをハッシュ化する。
     * @return BCryptPasswordEncoderのインスタンス。
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
