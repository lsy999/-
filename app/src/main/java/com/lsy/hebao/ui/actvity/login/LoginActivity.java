package com.lsy.hebao.ui.actvity.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lsy.hebao.R;
import com.lsy.hebao.base.BaseActivity;
import com.lsy.hebao.ui.actvity.sign.SignActivity;

public class LoginActivity extends BaseActivity {
    TextView tv_zc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        tv_zc= (TextView) findViewById(R.id.tv_zc);
        tv_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });
    }

    private void loadData() {
        Intent inter = new Intent(LoginActivity.this, SignActivity.class);
        LoginActivity.this.startActivity(inter);
    }
}
