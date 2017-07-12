package com.lsy.hebao.ui.actvity.sign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lsy.hebao.R;

import lib.view.progressview.SignProgressView;

public class SignActivity extends AppCompatActivity {
    private SignProgressView msign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        initView();
    }

    private void initView() {

        msign= (SignProgressView) findViewById(R.id.progressBar);

    }
}
