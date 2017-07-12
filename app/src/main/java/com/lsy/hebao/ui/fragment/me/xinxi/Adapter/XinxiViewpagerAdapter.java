package com.lsy.hebao.ui.fragment.me.xinxi.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.lsy.hebao.ui.fragment.invse.One.OneFragment;
import com.lsy.hebao.ui.fragment.invse.Two.TwoFragment;
import com.lsy.hebao.ui.fragment.me.xinxi.renwu.RenwuFragment;
import com.lsy.hebao.ui.fragment.me.xinxi.tequan.TequanFragment;

/**
 * Created by lsy on 2017/4/24.
 */

public class XinxiViewpagerAdapter extends FragmentPagerAdapter {
    private String[] mTab = new String[]{"我的任务", "我的特权"};

    public XinxiViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return RenwuFragment.newInstance();
        } else {
            return TequanFragment.newInstance();
        }
    }


    @Override
    public int getCount() {
        return mTab.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTab[position];
    }
}
