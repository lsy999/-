package com.lsy.hebao.ui.actvity.sign.view;

import com.lsy.hebao.base.BaseView;
import com.lsy.hebao.ui.actvity.sign.model.Register;
import com.lsy.hebao.ui.actvity.sign.model.Users;

/**
 * Created by lsy on 2017/7/13.
 */

public interface ISignView extends BaseView {
    void getDataSuccess(Register model);
    void getDataUserSuccess(Users model);
    void getDataFail(String msg);
}
