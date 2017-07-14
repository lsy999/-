package com.lsy.hebao.ui.actvity.sign.bean;

/**
 * Created by lsy on 2017/7/13.
 */

public class UsersBody {

    String username;
    String sms_code;
    String nick_name;
    String password;
    String repeat_password;
    String we_chat_service;
    String sn;
    String source_uuid;
    String invite_code;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSms_code() {
        return sms_code;
    }

    public void setSms_code(String sms_code) {
        this.sms_code = sms_code;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeat_password() {
        return repeat_password;
    }

    public void setRepeat_password(String repeat_password) {
        this.repeat_password = repeat_password;
    }

    public String getWe_chat_service() {
        return we_chat_service;
    }

    public void setWe_chat_service(String we_chat_service) {
        this.we_chat_service = we_chat_service;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getSource_uuid() {
        return source_uuid;
    }

    public void setSource_uuid(String source_uuid) {
        this.source_uuid = source_uuid;
    }

    public String getInvite_code() {
        return invite_code;
    }

    public void setInvite_code(String invite_code) {
        this.invite_code = invite_code;
    }
}
