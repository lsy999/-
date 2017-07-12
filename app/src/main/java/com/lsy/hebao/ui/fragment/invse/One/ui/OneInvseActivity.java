package com.lsy.hebao.ui.fragment.invse.One.ui;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.lsy.hebao.R;

import lib.view.polygon.PolygonChart;

public class OneInvseActivity extends AppCompatActivity {
    RelativeLayout invest_baozhang;
    PolygonChart polygon_charts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_invse);
        initView();
    }

    private void initView() {
        //保障
        invest_baozhang= (RelativeLayout) findViewById(R.id.invest_detail_collection_projectItem_2);
        //多边形
        polygon_charts= (PolygonChart) findViewById(R.id.polygon_charts);
        polygon_charts.setFillColor(Color.parseColor("#ffffba00"));
        initDate();
    }

    private void initDate() {
        polygon_charts.setChartData(new float[]{77,98,90,83,95});
        polygon_charts.setPointExplain(new String[]{"个人信息","财产状况","偿还能力","收入状况","信用情况"});

       invest_baozhang.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent inter=new Intent();
               inter.setClass(OneInvseActivity.this,OneBaozhangActivity.class);
               OneInvseActivity.this.startActivity(inter);
               OneInvseActivity.this.finish();
           }
       });
    }
}
