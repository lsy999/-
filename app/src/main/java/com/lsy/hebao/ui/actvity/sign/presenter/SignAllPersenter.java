package com.lsy.hebao.ui.actvity.sign.presenter;

import com.lsy.hebao.base.BasePresenter;
import com.lsy.hebao.ui.actvity.sign.bean.UsersBody;
import com.lsy.hebao.ui.actvity.sign.model.Register;
import com.lsy.hebao.ui.actvity.sign.model.Users;
import com.lsy.hebao.ui.actvity.sign.view.ISignView;
import com.lsy.hebao.ui.fragment.invse.Two.model.TwoAll;

import lib.retrofit.ApiCallback;

/**
 * Created by lsy on 2017/7/13.
 */

public class SignAllPersenter extends BasePresenter<ISignView> {

    public SignAllPersenter(ISignView iSignView) {
        attachView(iSignView);
    }

    public void loadDataRegister(String model) {
        addSubscription(apiStores.loadDataregister(model),
                new ApiCallback<Register>() {
                    @Override
                    public void onSuccess(Register model) {
                        mvpView.getDataSuccess(model);
                    }
                    @Override
                    public void onFailure(String msg) {
                        mvpView.getDataFail(msg);
                    }
                    @Override
                    public void onFinish() {
                    }
                });
    }
    public void loadDataUsers(String username, String sms_code,String nick_name ,String password) {
        addSubscription(apiStores.loadDatausers("13122222229","543917","lsy","123456ab"),
                new ApiCallback<Users>() {
                    @Override
                    public void onSuccess(Users model) {
                        mvpView.getDataUserSuccess(model);
                    }
                    @Override
                    public void onFailure(String msg) {
                        mvpView.getDataFail(msg);
                    }
                    @Override
                    public void onFinish() {
                    }
                });
    }
}
