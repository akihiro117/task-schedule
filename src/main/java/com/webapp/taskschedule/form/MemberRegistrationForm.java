package com.webapp.taskschedule.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 会員登録フォームに入力された値を格納するためのクラス。
 * @author akihiro
 *
 */
public class MemberRegistrationForm {
	@NotBlank(message = "入力してください。")
	private String eMail;

	@NotBlank(message = "入力してください。")
	@Size(min = 8, message="{2}文字以上入力してください。")
	private String password;

	//確認用のパスワード。
	@NotBlank(message = "入力してください。")
	@Size(min = 8, message="{2}文字以上入力してください。")
	private String passwordConfirm;

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

}
