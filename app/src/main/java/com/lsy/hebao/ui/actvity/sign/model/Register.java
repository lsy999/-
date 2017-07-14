package com.lsy.hebao.ui.actvity.sign.model;

import java.io.Serializable;

/**
 * Created by lsy on 2017/7/13.
 */

public class Register implements Serializable{

    /**
     * data : {"sms_content":"您正在注册添米账户，验证码是576294（不能告诉他人哦），请在10分钟内输入完成验证，咨询请致电400-058-9191。"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * sms_content : 您正在注册添米账户，验证码是576294（不能告诉他人哦），请在10分钟内输入完成验证，咨询请致电400-058-9191。
         */

        private String sms_content;

        public String getSms_content() {
            return sms_content;
        }

        public void setSms_content(String sms_content) {
            this.sms_content = sms_content;
        }
    }
}
