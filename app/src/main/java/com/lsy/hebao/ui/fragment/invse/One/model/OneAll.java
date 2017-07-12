package com.lsy.hebao.ui.fragment.invse.One.model;

import java.io.Serializable;
import java.util.List;

public class OneAll implements Serializable{
    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 11662
         * category : 1
         * subcategory : 11
         * bid_no : 1101
         * product_name : 月月薪
         * interest_rate : 0.0800
         * float_interest_rate : 0.0000
         * bid_amount : 1000000.00
         * bid_amount_pur : 0.00
         * bid_amount_bal : 1000000.00
         * bid_start_datetime : 2017-04-14 00:00:00
         * bid_due_datetime : 2017-04-14 23:59:00
         * status : 1
         * product_period : 29
         * bid_pur_limit_max : 500000.00
         * bid_pur_limit_min : 100.00
         * now : 2017-04-14 14:05:17
         * next_bid_start_datetime : null
         * schedule_desc : 00:30 11:00 16:00
         * amount_update_time : 00:30 11:00 16:00
         * app_product_detail_url : https://www.91tianmi.com/mobile/#/product/dcb-detail
         * app_product_qa_url : https://www.91tianmi.com/mobile/#/product/dcb-qa
         * asset : 63.56
         * app_schedule_desc : 11点，16点，24点更新份额
         * product_desc : 定期理财
         * product_due_datetime : 2017-05-14 23:59:51
         * offer_to :
         */

        private int id;
        private int category;
        private int subcategory;
        private String bid_no;
        private String product_name;
        private String interest_rate;
        private String float_interest_rate;
        private String bid_amount;
        private String bid_amount_pur;
        private String bid_amount_bal;
        private String bid_start_datetime;
        private String bid_due_datetime;
        private int status;
        private int product_period;
        private String bid_pur_limit_max;
        private String bid_pur_limit_min;
        private String now;
        private Object next_bid_start_datetime;
        private String schedule_desc;
        private String amount_update_time;
        private String app_product_detail_url;
        private String app_product_qa_url;
        private String asset;
        private String app_schedule_desc;
        private String product_desc;
        private String product_due_datetime;
        private String offer_to;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public int getSubcategory() {
            return subcategory;
        }

        public void setSubcategory(int subcategory) {
            this.subcategory = subcategory;
        }

        public String getBid_no() {
            return bid_no;
        }

        public void setBid_no(String bid_no) {
            this.bid_no = bid_no;
        }

        public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }

        public String getInterest_rate() {
            return interest_rate;
        }

        public void setInterest_rate(String interest_rate) {
            this.interest_rate = interest_rate;
        }

        public String getFloat_interest_rate() {
            return float_interest_rate;
        }

        public void setFloat_interest_rate(String float_interest_rate) {
            this.float_interest_rate = float_interest_rate;
        }

        public String getBid_amount() {
            return bid_amount;
        }

        public void setBid_amount(String bid_amount) {
            this.bid_amount = bid_amount;
        }

        public String getBid_amount_pur() {
            return bid_amount_pur;
        }

        public void setBid_amount_pur(String bid_amount_pur) {
            this.bid_amount_pur = bid_amount_pur;
        }

        public String getBid_amount_bal() {
            return bid_amount_bal;
        }

        public void setBid_amount_bal(String bid_amount_bal) {
            this.bid_amount_bal = bid_amount_bal;
        }

        public String getBid_start_datetime() {
            return bid_start_datetime;
        }

        public void setBid_start_datetime(String bid_start_datetime) {
            this.bid_start_datetime = bid_start_datetime;
        }

        public String getBid_due_datetime() {
            return bid_due_datetime;
        }

        public void setBid_due_datetime(String bid_due_datetime) {
            this.bid_due_datetime = bid_due_datetime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getProduct_period() {
            return product_period;
        }

        public void setProduct_period(int product_period) {
            this.product_period = product_period;
        }

        public String getBid_pur_limit_max() {
            return bid_pur_limit_max;
        }

        public void setBid_pur_limit_max(String bid_pur_limit_max) {
            this.bid_pur_limit_max = bid_pur_limit_max;
        }

        public String getBid_pur_limit_min() {
            return bid_pur_limit_min;
        }

        public void setBid_pur_limit_min(String bid_pur_limit_min) {
            this.bid_pur_limit_min = bid_pur_limit_min;
        }

        public String getNow() {
            return now;
        }

        public void setNow(String now) {
            this.now = now;
        }

        public Object getNext_bid_start_datetime() {
            return next_bid_start_datetime;
        }

        public void setNext_bid_start_datetime(Object next_bid_start_datetime) {
            this.next_bid_start_datetime = next_bid_start_datetime;
        }

        public String getSchedule_desc() {
            return schedule_desc;
        }

        public void setSchedule_desc(String schedule_desc) {
            this.schedule_desc = schedule_desc;
        }

        public String getAmount_update_time() {
            return amount_update_time;
        }

        public void setAmount_update_time(String amount_update_time) {
            this.amount_update_time = amount_update_time;
        }

        public String getApp_product_detail_url() {
            return app_product_detail_url;
        }

        public void setApp_product_detail_url(String app_product_detail_url) {
            this.app_product_detail_url = app_product_detail_url;
        }

        public String getApp_product_qa_url() {
            return app_product_qa_url;
        }

        public void setApp_product_qa_url(String app_product_qa_url) {
            this.app_product_qa_url = app_product_qa_url;
        }

        public String getAsset() {
            return asset;
        }

        public void setAsset(String asset) {
            this.asset = asset;
        }

        public String getApp_schedule_desc() {
            return app_schedule_desc;
        }

        public void setApp_schedule_desc(String app_schedule_desc) {
            this.app_schedule_desc = app_schedule_desc;
        }

        public String getProduct_desc() {
            return product_desc;
        }

        public void setProduct_desc(String product_desc) {
            this.product_desc = product_desc;
        }

        public String getProduct_due_datetime() {
            return product_due_datetime;
        }

        public void setProduct_due_datetime(String product_due_datetime) {
            this.product_due_datetime = product_due_datetime;
        }

        public String getOffer_to() {
            return offer_to;
        }

        public void setOffer_to(String offer_to) {
            this.offer_to = offer_to;
        }
    }
}
