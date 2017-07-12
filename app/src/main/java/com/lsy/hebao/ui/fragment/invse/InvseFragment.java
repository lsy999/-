package com.lsy.hebao.ui.fragment.invse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lsy.hebao.R;
import com.lsy.hebao.adapter.InvseViewPagerFragmentAdapter;
import com.lsy.hebao.base.BaseFragment;
import com.lsy.hebao.base.BaseMainFragment;


/**
 * Created by lsy on 2017/4/20.
 */

public class InvseFragment extends BaseMainFragment {
    private TabLayout mTab;
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    public static InvseFragment newInstance() {

        Bundle args = new Bundle();

        InvseFragment fragment = new InvseFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_invse_liao,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        mTab = (TabLayout) view.findViewById(R.id.tab);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);

        mToolbar.setTitle("投资");
        mTab.addTab(mTab.newTab().setText("产品"));
        mTab.addTab(mTab.newTab().setText("信息"));
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mViewPager.setAdapter(new InvseViewPagerFragmentAdapter(getChildFragmentManager()));
        mTab.setupWithViewPager(mViewPager);
    }
}
