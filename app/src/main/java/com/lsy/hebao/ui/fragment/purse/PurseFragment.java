package com.lsy.hebao.ui.fragment.purse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lsy.hebao.R;
import com.lsy.hebao.base.BaseFragment;
import com.lsy.hebao.base.BaseMainFragment;

import lib.view.progressbar.ColorArcProgressBar;

/**
 * Created by lsy on 2017/4/20.
 */

public class PurseFragment extends BaseMainFragment{

    private ColorArcProgressBar bar2;
    public static PurseFragment newInstance() {

        Bundle args = new Bundle();

        PurseFragment fragment = new PurseFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_purse_liao,container,false);
        initView(view);
        initDate();
        return view;
    }
    private void initView(View view) {
        bar2= (ColorArcProgressBar) view.findViewById(R.id.barInterest);
        bar2.setCurrentValues(40);
    }

    private void initDate() {
    }
}
