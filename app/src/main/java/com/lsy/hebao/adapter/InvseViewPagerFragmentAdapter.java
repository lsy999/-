package com.lsy.hebao.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lsy.hebao.ui.fragment.invse.One.OneFragment;
import com.lsy.hebao.ui.fragment.invse.Two.TwoFragment;


/**
 * Created by YoKeyword on 16/6/5.
 */
public class InvseViewPagerFragmentAdapter extends FragmentPagerAdapter {
    private String[] mTab = new String[]{"产品", "信息"};

    public InvseViewPagerFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return OneFragment.newInstance();
        } else {
            return TwoFragment.newInstance();
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
