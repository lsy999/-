package com.lsy.hebao.ui.actvity.sign;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lsy.hebao.R;
import com.lsy.hebao.base.MvpActivity;
import com.lsy.hebao.ui.actvity.MainActivity;
import com.lsy.hebao.ui.actvity.sign.bean.UsersBody;
import com.lsy.hebao.ui.actvity.sign.model.Register;
import com.lsy.hebao.ui.actvity.sign.model.Users;
import com.lsy.hebao.ui.actvity.sign.presenter.SignAllPersenter;
import com.lsy.hebao.ui.actvity.sign.view.ISignView;

public class SignActivity extends MvpActivity<SignAllPersenter>implements ISignView {
    EditText et_phone,et_yzm,et_mima,et_name;
    TextView tv_yzm;
    Button bt_zc;
    ImageView iv_zc;
    String Sms_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        initView();



    }

    @Override
    protected SignAllPersenter createPresenter() {
        return new SignAllPersenter(this);
    }

    private void initView() {
        bt_zc= (Button) findViewById(R.id.bt_zc);
        tv_yzm= (TextView) findViewById(R.id.tv_yzm);
        et_phone= (EditText) findViewById(R.id.et_phone);
        et_yzm= (EditText) findViewById(R.id.et_yzm);
        et_mima= (EditText) findViewById(R.id.et_mima);
        et_name= (EditText) findViewById(R.id.et_name);
        iv_zc= (ImageView) findViewById(R.id.iv_zc);
        bt_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData();
            }
        });

        tv_yzm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mvpPresenter.loadDataRegister("13122222229");
            }
        });
    }

    private void initData() {
        UsersBody users=new UsersBody();
        et_name.setText(users.getNick_name());
        et_phone.setText(users.getUsername());
        et_yzm.setText(users.getSms_code());
        et_mima.setText(users.getPassword());
        mvpPresenter.loadDataUsers("13122222229","543917","lsy","123456ab");
    }


    @Override
    public void getDataSuccess(Register model) {
        dataregisterSuccess(model);
    }

    @Override
    public void getDataUserSuccess(Users model) {
        if (model.getData()!=null){
            Users.DataBean dataBean =model.getData();
            String token =dataBean.getKey();
            String id =dataBean.getId_no();
            String username = dataBean.getUsername();
            String nick_name=dataBean.getNick_name();
            Intent intent = new Intent(SignActivity.this, MainActivity.class);
            intent.putExtra("token",token);
            intent.putExtra("id",id);
            intent.putExtra("username",username);
            intent.putExtra("nick_name",nick_name);
            SignActivity.this.startActivity(intent);
            Toast.makeText(SignActivity.this,"请求成功！",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(SignActivity.this,"请求失败！",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void getDataFail(String msg) {

    }

    private void dataregisterSuccess(Register model) {
       Register.DataBean result = model.getData();
        if (result!=null){
         Sms_content =  result.getSms_content();
            et_yzm.setText(Sms_content);
        }else {
            Toast.makeText(SignActivity.this,"验证码未获取到，请重试！",Toast.LENGTH_LONG).show();
        }

    }
}
