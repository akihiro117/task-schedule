//MemberRegistrationController.java
//Created by Akihiro Yamada on 2018/12/09.
//Copyright (c) 2018. All Rights Reserved.

package com.webapp.taskschedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.webapp.taskschedule.entity.MemberEntity;
import com.webapp.taskschedule.form.MemberRegistrationForm;
import com.webapp.taskschedule.service.MemberRegistrationService;

/**
 * 会員登録機能を提供するクラス。
 *
 */
@Controller
@SessionAttributes(value = "form")
public class MemberRegistrationController {

    //メンバー登録フォーム。
    private static String MEMBER_REGISTRATION_FORM = "member-registration-form";
    //確認画面。
    private static String MEMBER_REGISTRATION_CONFIRM = "member-registration-confirm";

    @Autowired
    private MemberRegistrationService memberRegistrationService;

    /**
     * 会員情報入力画面を表示。
     * @return 会員情報入力画面。
     */
    @RequestMapping("/member-registration-form")
    public String showMemberRegistrationForm(Model model) {

        model.addAttribute("source", "login");

        //これを書いていないことが原因だった
        model.addAttribute(new MemberRegistrationForm());

        //会員情報入力画面に遷移。
        return MEMBER_REGISTRATION_FORM;
    }

    /**
     * 会員情報登録の確認画面を表示。
     * 会員情報の入力チェックを行う。
     * @param memberForm 入力された会員情報。
     * @param model sessionを渡すために使用するModelオブジェクト。
     * @return 会員情報登録確認画面。
     */
    @RequestMapping("/member-registration-confirm")
    public String showRegistrationConfirm(
            @Validated @ModelAttribute MemberRegistrationForm memberRegistrationForm,
            BindingResult result, Model model) {

        //パスワードの相関項目エラーの有無。
        boolean hasCorrelationErr = !memberRegistrationForm.getPassword()
                .equals(memberRegistrationForm.getPasswordConfirm());

        if (hasCorrelationErr) {
            model.addAttribute("errMsg", "異なるパスワードが入力されています。");
            return MEMBER_REGISTRATION_FORM;
        }

        if (result.hasErrors()) {
            //単項目の入力エラーがある場合。
            return MEMBER_REGISTRATION_FORM;
        }

        //確認画面への表示と登録を行うため、値をsessionにセット。
        model.addAttribute("form", memberRegistrationForm);

        //会員情報登録確認画面。
        return MEMBER_REGISTRATION_CONFIRM;
    }

    /**
     * 入力された会員情報をDBに登録。
     * @return 会員登録の結果画面。
    **/
    @RequestMapping(value = "/member-registration-result", params = "regist")
    public String registerMember(
            @ModelAttribute("form") MemberRegistrationForm form) {

        MemberEntity entity = new MemberEntity();
        entity.setEMail(form.geteMail());
        entity.setPassword(form.getPassword());

        memberRegistrationService.registerMember(entity);
        //会員登録の結果画面。
        return "member-registration-result";
    }

    @RequestMapping(value = "/member-registration-result", params = "revise")
    public String returnRegistrationForm(
            @ModelAttribute("form") MemberRegistrationForm memberRegistrationForm,
            Model model) {
        model.addAttribute("source", "revise");

        memberRegistrationForm.setPassword("");

        //入力した値を登録フォームに表示したままにするために、
        //attributeにformを追加する。
        model.addAttribute(memberRegistrationForm);

        return MEMBER_REGISTRATION_FORM;
    }

}
