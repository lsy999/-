package com.lsy.hebao.ui.fragment.me.share;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.lsy.hebao.R;

public class MeShareActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_share);
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        mToolbar.setTitle("分享荷包");
    }
}
