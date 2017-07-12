package com.lsy.hebao.ui.fragment.me.xinxi.tequan;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lsy.hebao.R;
import com.lsy.hebao.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lsy on 2017/4/24.
 */

public class TequanFragment extends BaseFragment {

    RecyclerView recyclerView;
    public static TequanFragment newInstance() {

        Bundle args = new Bundle();

        TequanFragment fragment = new TequanFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragment_me_xinxi_tequan, null);
        initView(view);
        initDate();
        return view;
    }

    private void initDate() {

    }

    private void initView(View view) {
        recyclerView = (RecyclerView)view.findViewById(R.id.rv_tequan);



    }

    }


