package com.lsy.hebao.ui.fragment.invse.One.presenter;

import com.lsy.hebao.base.BasePresenter;
import com.lsy.hebao.ui.fragment.invse.One.model.OneAll;
import com.lsy.hebao.ui.fragment.invse.One.view.IOneView;

import lib.retrofit.ApiCallback;

/**
* Created by lsy on 2017/04/13
*/

public class OnePresenter extends BasePresenter<IOneView> {

    public OnePresenter(IOneView view) {
        attachView(view);
    }

    public void loadDataByRetrofitRxjava() {
        mvpView.showLoading();
        addSubscription(apiStores.loadDataOne(),
                new ApiCallback<OneAll>() {
                    @Override
                    public void onSuccess(OneAll model) {
                        mvpView.getDataSuccess(model);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.getDataFail(msg);
                    }


                    @Override
                    public void onFinish() {
                        mvpView.hideLoading();
                    }

                });
    }


}