package com.lsy.hebao.ui.fragment.home.keyong;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.lsy.hebao.R;
import com.lsy.hebao.ui.fragment.home.keyong.adpter.DropMenuAdapter;
import com.lsy.hebao.ui.fragment.home.keyong.entity.FilterUrl;

import lib.filter.DropDownMenu;
import lib.filter.interfaces.OnFilterDoneListener;

import static com.lsy.hebao.R.id.mFilterContentView;

public class HomeKeyongActivity extends Activity implements OnFilterDoneListener {
    private DropDownMenu dropDownMenu;
    private TextView tv_home_balance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_keyong);
        initView();
        initFilterDropDownView();
    }

    private void initView() {
        dropDownMenu= (DropDownMenu) findViewById(R.id.balance_dropDownMenu);
        tv_home_balance= (TextView) findViewById(mFilterContentView);
    }

    private void initFilterDropDownView() {
        String[] titleList = new String[]{ "可用余额"};
        dropDownMenu.setMenuAdapter(new DropMenuAdapter(this, titleList, this));

    }

    @Override
    public void onFilterDone(int position, String positionTitle, String urlValue) {
        dropDownMenu.close();
        //tv_home_balance.setText(FilterUrl.instance().toString());
        tv_home_balance.setText(FilterUrl.instance().positionTitle+FilterUrl.instance().doubleListLeft);

    }
}

