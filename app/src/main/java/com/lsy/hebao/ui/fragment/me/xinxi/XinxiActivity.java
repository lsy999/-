package com.lsy.hebao.ui.fragment.me.xinxi;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import android.view.View;
import android.widget.ProgressBar;

import com.lsy.hebao.R;
import com.lsy.hebao.base.BaseActivity;
import com.lsy.hebao.ui.fragment.me.xinxi.Adapter.XinxiViewpagerAdapter;
import com.lsy.hebao.ui.fragment.me.xinxi.ui.XinxiXiugaiActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class XinxiActivity extends BaseActivity {
    private TabLayout mTab;
    private ViewPager mViewPager;
    private CircleImageView civ_xtx;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_me_xinxi);
        initView();
        initDate();
    }

    private void initDate() {

        mViewPager.setAdapter(new XinxiViewpagerAdapter(getSupportFragmentManager()));
        mTab.setupWithViewPager(mViewPager);
        civ_xtx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(XinxiActivity.this, XinxiXiugaiActivity.class);
                XinxiActivity.this.startActivity(intent);
            }
        });
    }


    private void initView() {
        ProgressBar gradient_progress = (ProgressBar) findViewById(R.id.gradient_progress);
        ObjectAnimator
                .ofInt(gradient_progress, "progress", 0, 60)
                .setDuration(500)
                .start();
        mTab = (TabLayout)findViewById(R.id.tab_xinxi);
        mViewPager = (ViewPager)findViewById(R.id.viewPager_xinxi);
        mTab.addTab(mTab.newTab().setText("我的特权"));
        mTab.addTab(mTab.newTab().setText("我的任务"));
        civ_xtx= (CircleImageView) findViewById(R.id.cim_xinix);

    }

}
