package com.lsy.hebao.ui.fragment.invse.Two.presenter;


import com.lsy.hebao.base.BasePresenter;
import com.lsy.hebao.ui.fragment.invse.Two.model.TwoAll;
import com.lsy.hebao.ui.fragment.invse.Two.view.ITwoView;

import lib.retrofit.ApiCallback;

public class TwoAllPresenter extends BasePresenter<ITwoView> {

    public TwoAllPresenter(ITwoView view) {
        attachView(view);
    }

    public void loadDataByRetrofitRxjava() {
        addSubscription(apiStores.loadDataTwo(),
                new ApiCallback<TwoAll>() {
                    @Override
                    public void onSuccess(TwoAll model) {
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

}
