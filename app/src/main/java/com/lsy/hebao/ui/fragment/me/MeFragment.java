package com.lsy.hebao.ui.fragment.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.lsy.hebao.R;
import com.lsy.hebao.base.BaseMainFragment;
import com.lsy.hebao.ui.fragment.me.msg.MeMsgActivity;
import com.lsy.hebao.ui.fragment.me.share.MeShareActivity;
import com.lsy.hebao.ui.fragment.me.xinxi.XinxiActivity;

/**
 * Created by lsy on 2017/4/20.
 */

public class MeFragment extends BaseMainFragment{
    private LinearLayout ll_message,ll_share;
    private Toolbar mToolbar;
    private RelativeLayout rl_header;

    public static MeFragment newInstance() {

        Bundle args = new Bundle();

        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_me_liao,container,false);


        initView(view);
        initDate();
        return view;
    }


    private void initView(View view) {
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        mToolbar.setTitle("我");
        ll_message= (LinearLayout) view.findViewById(R.id.ll_message);
        ll_share= (LinearLayout) view.findViewById(R.id.ll_hebao_share);
        rl_header= (RelativeLayout) view.findViewById(R.id.rl_header);

    }

    private void initDate() {
        ll_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.setClass(getContext(), MeMsgActivity.class);
                MeFragment.this.startActivity(i);
            }
        });
        ll_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent();
                i1.setClass(getContext(), MeShareActivity.class);
                MeFragment.this.startActivity(i1);
            }
        });
        rl_header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent();
                i2.setClass(getContext(),XinxiActivity.class);
                MeFragment.this.startActivity(i2);
            }
        });

    }
}
