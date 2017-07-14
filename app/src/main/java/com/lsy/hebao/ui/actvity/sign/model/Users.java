package com.lsy.hebao.ui.actvity.sign.model;

import java.io.Serializable;

/**
 * Created by lsy on 2017/7/13.
 */

public class Users implements Serializable{

    /**
     * data : {"id":58400,"username":"13122030011","nick_name":"123","full_name":null,"id_no":null,"id_no_valid_flag":false,"email":null,"qq":null,"we_chat_service":null,"we_chat_subscriber":null,"hui_fu_balance":"0.00","is_active":true,"uuid":"31906926-6862-11e7-a6a5-00163e003ef7","trade_password_flag":false,"withdraw_flag":false,"priority":0,"key":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6IjEzMTIyMDMwMDExIiwidXNlcl9pZCI6NTg0MDAsInVzZXJfYWdlbnQiOiJ3ZWIiLCJleHAiOjE1MDA2MjA0NjMsImxhc3RfbG9naW4iOjAsIm9yaWdfaWF0IjoxNTAwMDE1NjYzLCJlbWFpbCI6bnVsbH0.zSJUGCewc4nPNDm-qH2F8zaV8ZJWzowN_jkw8VuNhwc","timestamp":1500015663,"xsb_purchase_status":true,"zl_flag":0,"xw_flag":0,"change_bank_flag":0,"change_mobile_flag":0}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * id : 58400
         * username : 13122030011
         * nick_name : 123
         * full_name : null
         * id_no : null
         * id_no_valid_flag : false
         * email : null
         * qq : null
         * we_chat_service : null
         * we_chat_subscriber : null
         * hui_fu_balance : 0.00
         * is_active : true
         * uuid : 31906926-6862-11e7-a6a5-00163e003ef7
         * trade_password_flag : false
         * withdraw_flag : false
         * priority : 0
         * key : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6IjEzMTIyMDMwMDExIiwidXNlcl9pZCI6NTg0MDAsInVzZXJfYWdlbnQiOiJ3ZWIiLCJleHAiOjE1MDA2MjA0NjMsImxhc3RfbG9naW4iOjAsIm9yaWdfaWF0IjoxNTAwMDE1NjYzLCJlbWFpbCI6bnVsbH0.zSJUGCewc4nPNDm-qH2F8zaV8ZJWzowN_jkw8VuNhwc
         * timestamp : 1500015663
         * xsb_purchase_status : true
         * zl_flag : 0
         * xw_flag : 0
         * change_bank_flag : 0
         * change_mobile_flag : 0
         */

        private int id;
        private String username;
        private String nick_name;
        private String full_name;
        private String id_no;
        private boolean id_no_valid_flag;
        private String email;
        private String qq;
        private String we_chat_service;
        private String we_chat_subscriber;
        private String hui_fu_balance;
        private boolean is_active;
        private String uuid;
        private boolean trade_password_flag;
        private boolean withdraw_flag;
        private int priority;
        private String key;
        private int timestamp;
        private boolean xsb_purchase_status;
        private int zl_flag;
        private int xw_flag;
        private int change_bank_flag;
        private int change_mobile_flag;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getNick_name() {
            return nick_name;
        }

        public void setNick_name(String nick_name) {
            this.nick_name = nick_name;
        }

        public String getFull_name() {
            return full_name;
        }

        public void setFull_name(String full_name) {
            this.full_name = full_name;
        }

        public String getId_no() {
            return id_no;
        }

        public void setId_no(String id_no) {
            this.id_no = id_no;
        }

        public boolean isId_no_valid_flag() {
            return id_no_valid_flag;
        }

        public void setId_no_valid_flag(boolean id_no_valid_flag) {
            this.id_no_valid_flag = id_no_valid_flag;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getWe_chat_service() {
            return we_chat_service;
        }

        public void setWe_chat_service(String we_chat_service) {
            this.we_chat_service = we_chat_service;
        }

        public String getWe_chat_subscriber() {
            return we_chat_subscriber;
        }

        public void setWe_chat_subscriber(String we_chat_subscriber) {
            this.we_chat_subscriber = we_chat_subscriber;
        }

        public String getHui_fu_balance() {
            return hui_fu_balance;
        }

        public void setHui_fu_balance(String hui_fu_balance) {
            this.hui_fu_balance = hui_fu_balance;
        }

        public boolean is_active() {
            return is_active;
        }

        public void setIs_active(boolean is_active) {
            this.is_active = is_active;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public boolean isTrade_password_flag() {
            return trade_password_flag;
        }

        public void setTrade_password_flag(boolean trade_password_flag) {
            this.trade_password_flag = trade_password_flag;
        }

        public boolean isWithdraw_flag() {
            return withdraw_flag;
        }

        public void setWithdraw_flag(boolean withdraw_flag) {
            this.withdraw_flag = withdraw_flag;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public boolean isXsb_purchase_status() {
            return xsb_purchase_status;
        }

        public void setXsb_purchase_status(boolean xsb_purchase_status) {
            this.xsb_purchase_status = xsb_purchase_status;
        }

        public int getZl_flag() {
            return zl_flag;
        }

        public void setZl_flag(int zl_flag) {
            this.zl_flag = zl_flag;
        }

        public int getXw_flag() {
            return xw_flag;
        }

        public void setXw_flag(int xw_flag) {
            this.xw_flag = xw_flag;
        }

        public int getChange_bank_flag() {
            return change_bank_flag;
        }

        public void setChange_bank_flag(int change_bank_flag) {
            this.change_bank_flag = change_bank_flag;
        }

        public int getChange_mobile_flag() {
            return change_mobile_flag;
        }

        public void setChange_mobile_flag(int change_mobile_flag) {
            this.change_mobile_flag = change_mobile_flag;
        }
    }
}
