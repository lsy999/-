package com.lsy.hebao.ui.fragment.invse.Two;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.lsy.hebao.R;
import com.lsy.hebao.base.BaseFragment;
import com.lsy.hebao.base.MvpFragment;
import com.lsy.hebao.ui.fragment.invse.One.OneFragment;
import com.lsy.hebao.ui.fragment.invse.Two.adapter.TwoAllAdapter;
import com.lsy.hebao.ui.fragment.invse.Two.model.TwoAll;
import com.lsy.hebao.ui.fragment.invse.Two.presenter.TwoAllPresenter;
import com.lsy.hebao.ui.fragment.invse.Two.view.ITwoView;

import java.util.ArrayList;
import java.util.List;

import lib.view.listview.MyListView;

/**
 * Created by lsy on 2017/4/20.
 */

public class TwoFragment extends MvpFragment<TwoAllPresenter> implements ITwoView{
    private MyListView two_lv;
    private TwoAllAdapter adapter;
    private List<TwoAll.DataBean> list;


    public static TwoFragment newInstance() {

        Bundle args = new Bundle();

        TwoFragment fragment = new TwoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragment_invse_two, null);

        initView(view);
        initDate();
        return view;
    }

    private void initView(View view) {
        two_lv = (MyListView) view.findViewById(R.id.two_lv);
        mvpPresenter = new TwoAllPresenter(this);
        list=new ArrayList<>();
        if (adapter == null) {

            adapter = new TwoAllAdapter(list);
        }
        two_lv.setAdapter(adapter);

    }

    @Override
    protected TwoAllPresenter createPresenter() {
        return new TwoAllPresenter(this);
    }
    private void initDate() {
        mvpPresenter.loadDataByRetrofitRxjava();
    }

    @Override
    public void getDataSuccess(TwoAll model) {
        dataSuccess(model);
    }

    @Override
    public void getDataFail(String msg) {
        System.out.print("网络不给力"+msg);
        Toast.makeText(getContext(),"网络不给力",Toast.LENGTH_LONG).show();

    }
    private void dataSuccess(TwoAll model) {

        if (model != null && model.getData() != null && model.getData().size() > 0) {
            list.addAll(model.getData());
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {


    }

    @Override
    public void hideLoading() {

    }

}
