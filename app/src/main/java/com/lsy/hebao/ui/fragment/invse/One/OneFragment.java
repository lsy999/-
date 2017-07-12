package com.lsy.hebao.ui.fragment.invse.One;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.lsy.hebao.R;
import com.lsy.hebao.base.MvpFragment;
import com.lsy.hebao.ui.fragment.invse.One.adapter.OneAllAdapter;
import com.lsy.hebao.ui.fragment.invse.One.model.OneAll;
import com.lsy.hebao.ui.fragment.invse.One.presenter.OnePresenter;
import com.lsy.hebao.ui.fragment.invse.One.ui.OneInvseActivity;
import com.lsy.hebao.ui.fragment.invse.One.view.IOneView;

import java.util.ArrayList;
import java.util.List;

import lib.view.listview.MyListView;

/**
 * Created by lsy on 2017/4/20.
 */

public class OneFragment extends MvpFragment<OnePresenter> implements IOneView {
    private MyListView mlistview;
    private OneAllAdapter adapter;
    private List<OneAll.DataBean> list;

    public static OneFragment newInstance() {

        Bundle args = new Bundle();

        OneFragment fragment = new OneFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragment_invse_one, null);
        initView(view);
        initDate();
        return view;
    }

    private void initView(View view) {

        mlistview = (MyListView) view.findViewById(R.id.listview);
        mvpPresenter = new OnePresenter(this);
        list = new ArrayList<>();
        if (adapter == null) {
            adapter = new OneAllAdapter(getContext(), list);
        }
        mlistview.setAdapter(adapter);

        mlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent=new Intent();
               intent.setClass(getActivity(), OneInvseActivity.class);
               getActivity().startActivity(intent);

           }
       });

    }


    @Override
    protected OnePresenter createPresenter() {
        return new OnePresenter(this);
    }

    private void initDate() {

        mvpPresenter.loadDataByRetrofitRxjava();
    }

    @Override
    public void getDataSuccess(OneAll model) {
        dataSuccess(model);
    }


    @Override
    public void getDataFail(String msg) {

        System.out.print("网络不给力" + msg);
        Toast.makeText(getContext(), "网络不给力", Toast.LENGTH_LONG).show();

    }

    private void dataSuccess(OneAll model) {
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
