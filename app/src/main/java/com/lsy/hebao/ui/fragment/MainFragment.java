package com.lsy.hebao.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lsy.hebao.R;
import com.lsy.hebao.base.BaseFragment;
import com.lsy.hebao.ui.fragment.home.HomeFragment;
import com.lsy.hebao.ui.fragment.invse.InvseFragment;
import com.lsy.hebao.ui.fragment.me.MeFragment;
import com.lsy.hebao.ui.fragment.purse.PurseFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import lib.event.StartBrotherEvent;
import lib.event.TabSelectedEvent;
import lib.view.button.BottomBar;
import lib.view.button.BottomBarTab;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by lsy on 2017/4/20.
 */

public class MainFragment extends BaseFragment {
    private static final int REQ_MSG = 10;

    public static final int HOME = 0;
    public static final int PURSE = 1;
    public static final int INVEST= 2;
    public static final int ME=3;

    private SupportFragment[] mFragments = new SupportFragment[4];

    private BottomBar mBottomBar;


    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_liao, container, false);

        if (savedInstanceState == null) {
            mFragments[HOME] = HomeFragment.newInstance();
            mFragments[PURSE] = PurseFragment.newInstance();
            mFragments[INVEST] = InvseFragment.newInstance();
            mFragments[ME]= MeFragment.newInstance();

            loadMultipleRootFragment(R.id.fl_tab_container, HOME,
                    mFragments[HOME],
                    mFragments[PURSE],
                    mFragments[INVEST],
                    mFragments[ME] );
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用,也可以通过getChildFragmentManager.getFragments()自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[HOME] = findChildFragment(HomeFragment.class);
            mFragments[PURSE] = findChildFragment(PurseFragment.class);
            mFragments[INVEST] = findChildFragment(InvseFragment.class);
            mFragments[ME]=findChildFragment(MeFragment.class);
        }

        initView(view);
        return view;
    }

    private void initView(View view) {
        EventBus.getDefault().register(this);
        mBottomBar = (BottomBar) view.findViewById(R.id.bottomBar);

        mBottomBar
                .addItem(new BottomBarTab(_mActivity, R.drawable.toolbar_btn_shouye_down, "首页"))
                .addItem(new BottomBarTab(_mActivity, R.drawable.toolbar_btn_purse_down, "零钱包"))
                .addItem(new BottomBarTab(_mActivity,R.drawable.toolbar_btn_touzi_down,"投资"))
                .addItem(new BottomBarTab(_mActivity, R.drawable.toolbar_btn_wo_down, "我"));



        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(mFragments[position], mFragments[prePosition]);

            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {
                // 这里推荐使用EventBus来实现 -> 解耦
                // 在FirstPagerFragment,FirstHomeFragment中接收, 因为是嵌套的Fragment
                // 主要为了交互: 重选tab 如果列表不在顶部则移动到顶部,如果已经在顶部,则刷新
                EventBus.getDefault().post(new TabSelectedEvent(position));
            }
        });
    }

    @Override
    protected void onFragmentResult(int requestCode, int resultCode, Bundle data) {
        super.onFragmentResult(requestCode, resultCode, data);
        if (requestCode == REQ_MSG && resultCode == RESULT_OK) {

        }
    }

    /**
     * start other BrotherFragment
     */
    @Subscribe
    public void startBrother(StartBrotherEvent event) {
        start(event.targetFragment);
    }

    @Override
    public void onDestroyView() {
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }
}
