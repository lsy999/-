package com.lsy.hebao.ui.fragment.invse.Two.view;

import com.lsy.hebao.base.BaseView;
import com.lsy.hebao.ui.fragment.invse.Two.model.TwoAll;

public interface ITwoView extends BaseView {

    void getDataSuccess(TwoAll model);

    void getDataFail(String msg);

}
