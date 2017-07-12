package com.lsy.hebao.ui.fragment.home.charts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lsy.hebao.R;
import com.lsy.hebao.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lib.view.charts.ColumnChartView;

public class HomeChartsActivity extends BaseActivity {
    private ColumnChartView myChartView;
    private List<Float> chartList;
    private RelativeLayout relativeLayout;//
    private LinearLayout llChart;//
    private ImageView img_topback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_charts);
        initView();

    }

    private void initView() {
        myChartView = (ColumnChartView) findViewById(R.id.columnchart);
        initChatView();
        img_topback= (ImageView) findViewById(R.id.img_topback);
        img_topback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initChatView() {
        chartList = new ArrayList<Float>();
        relativeLayout= (RelativeLayout) findViewById(R.id.Rl_home_charts);
        relativeLayout.removeView(llChart);
        Random random = new Random();
        while (chartList.size() < 12) {
            int randomInt = random.nextInt(100);
            chartList.add((float) randomInt);
        }

        myChartView.setList(chartList);
        myChartView.setListener(new ColumnChartView.getNumberListener() {
            @Override
            public void getNumber(int number, int x, int y) {
                relativeLayout.removeView(llChart);
                llChart = (LinearLayout) LayoutInflater.from(HomeChartsActivity.this).inflate(R.layout.item_home_charts_liao, null);
                TextView tvMoney = (TextView) findViewById(R.id.tv_shouru_pro);
                tvMoney.setText(chartList.get(number)+"");
                llChart.measure(0, 0);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                params.leftMargin = x - 100;
                if (x - 100 < 0) {
                    params.leftMargin = 0;
                } else if (x - 100 > relativeLayout.getWidth() - llChart.getMeasuredWidth()) {
                    params.leftMargin = relativeLayout.getWidth() - llChart.getMeasuredWidth();
                }

                llChart.setLayoutParams(params);
                relativeLayout.addView(llChart);
            }
        });

    }
}
