package com.lsy.hebao.ui.fragment.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lsy.hebao.R;
import com.lsy.hebao.base.BaseMainFragment;
import com.lsy.hebao.ui.fragment.home.charts.HomeChartsActivity;
import com.lsy.hebao.ui.fragment.home.keyong.HomeKeyongActivity;
import com.lsy.hebao.ui.fragment.home.myinvse.HomeMyinvseActivity;
import com.lsy.hebao.ui.fragment.home.purse.HomePurseActivity;
import com.lsy.hebao.ui.fragment.home.tiyanjin.HomeTiyanjinActivity;
import com.lsy.hebao.ui.fragment.home.zongzichan.HomeZongzichanActivity;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.view.LineChartView;
import lib.pullable.PullToRefreshLayout;


/**
 * Created by lsy on 2017/4/20.
 */

public class HomeFragment extends BaseMainFragment{
    private LinearLayout home_charts_big,home_keyong,home_lingqianbao,home_zongzichan,home_tiyanjin,home_invest;
    private PullToRefreshLayout prl_home;

    private LineChartView lineChart;
    String[] weeks = {"11","12","13","14","15","16","17"};//X轴的标注
    int[] weather = {9,7,6,7,8,6,8};//图表的数据
    private List<PointValue> mPointValues = new ArrayList<PointValue>();
    private List<AxisValue> mAxisValues = new ArrayList<AxisValue>();

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home_liao,container,false);
        initView(view);
        initDate();
     /*   prl_home= (PullToRefreshLayout) view.findViewById(R.id.prl_home);
        prl_home.setOnRefreshListener(new MyPullListener());*/
        return view;
    }

    private void initView(View view) {
        home_charts_big= (LinearLayout) view.findViewById(R.id.ll_home_charts_big);//趋势图
        home_zongzichan= (LinearLayout) view.findViewById(R.id.ll_home_zongzichan);//总资产
        home_lingqianbao= (LinearLayout) view.findViewById(R.id.ll_home_lingqianbao);//零钱包
        home_keyong= (LinearLayout) view.findViewById(R.id.ll_home_keyong);//可用余额
        home_tiyanjin= (LinearLayout) view.findViewById(R.id.ll_home_tiyanjin);//体验金
        home_invest= (LinearLayout) view.findViewById(R.id.ll_home_invest);//我的投资

        lineChart= (LineChartView) view.findViewById(R.id.lc_home_charts);
        getAxisLables();//获取x轴的标注
        getAxisPoints();//获取坐标点
        initLineChart();

    }
    /**
     * 初始化LineChart的一些设置
     */
    private void initLineChart(){
        Line line = new Line(mPointValues).setColor(Color.parseColor("#ffe25023")).setCubic(false);  //折线的颜色
        List<Line> lines = new ArrayList<Line>();
        line.setShape(ValueShape.CIRCLE);//折线图上每个数据点的形状  这里是圆形 （有三种 ：ValueShape.SQUARE  ValueShape.CIRCLE  ValueShape.SQUARE）
        line.setCubic(false);//曲线是否平滑
        line.setFilled(false);//是否填充曲线的面积
        line.setHasLines(true);//是否用直线显示。如果为false 则没有曲线只有点显示
        line.setHasPoints(true);//是否显示圆点 如果为false 则没有原点只有点显示
        line.setPointRadius(3);
        line.setHasLabels(true);
        lines.add(line);
        LineChartData data = new LineChartData();
        data.setLines(lines);

        //坐标轴
        Axis axisX = new Axis(); //X轴
        axisX.setHasTiltedLabels(true);
        axisX.setTextSize(7);//设置字体大小
        axisX.setMaxLabelChars(7);  //最多几个X轴坐标
        axisX.setValues(mAxisValues);  //填充X轴的坐标名称
        data.setAxisXBottom(axisX); //x 轴在底部
        axisX.setHasTiltedLabels(false);
//	    data.setAxisXTop(axisX);  //x 轴在顶部


//        Axis axisY = new Axis();  //Y轴
//        axisY.setMaxLabelChars(7); //默认是3，只能看最后三个数字
//        axisY.setTextSize(7);//设置字体大小
//        data.setAxisYLeft(axisY);  //Y轴设置在左边
//	    data.setAxisYRight(axisY);  //y轴设置在右边

        //设置行为属性，支持缩放、滑动以及平移
        lineChart.setInteractive(true);
        lineChart.setZoomType(ZoomType.HORIZONTAL_AND_VERTICAL);
        lineChart.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);
        lineChart.setLineChartData(data);
        lineChart.setVisibility(View.VISIBLE);
    }


    /**
     * X 轴的显示
     */
    private void getAxisLables(){
        for (int i = 0; i < weeks.length; i++) {
            mAxisValues.add(new AxisValue(i).setLabel(weeks[i]));
        }
    }

    /**
     * 图表的每个点的显示
     */
    private void getAxisPoints(){
        for (int i = 0; i < weather.length; i++) {
            mPointValues.add(new PointValue(i, weather[i]));
        }
    }


    private void initDate() {
        //趋势图
        home_charts_big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(), HomeChartsActivity.class);
                startActivity(intent1);
            }
        });
        //可用
        home_keyong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(getActivity(), HomeKeyongActivity.class);
                startActivity(intent5);
            }
        });
        //零钱包
        home_lingqianbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(), HomePurseActivity.class);
                startActivity(intent2);
            }
        });

        //总投资
        home_zongzichan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getActivity(), HomeZongzichanActivity.class);
                startActivity(intent3);
            }
        });
        //体验金
        home_tiyanjin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getActivity(), HomeTiyanjinActivity.class);
                startActivity(intent4);
            }
        });
        //我的投资
        home_tiyanjin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getActivity(), HomeMyinvseActivity.class);
                startActivity(intent4);
            }
        });

    }
}
