package com.lsy.hebao.ui.fragment.invse.One.view;


import com.lsy.hebao.base.BaseView;
import com.lsy.hebao.ui.fragment.invse.One.model.OneAll;

/**
 * Created by lsy on 2017/4/13.
 */

public interface IOneView extends BaseView {

    void getDataSuccess(OneAll model);

    void getDataFail(String msg);

}
