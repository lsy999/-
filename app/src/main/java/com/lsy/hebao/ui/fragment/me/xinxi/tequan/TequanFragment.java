package com.lsy.hebao.ui.fragment.me.xinxi.tequan;

import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

import com.lsy.hebao.R;
import com.lsy.hebao.base.BaseFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lsy on 2017/4/24.
 */

public class TequanFragment extends BaseFragment {
    private GridView gview,gview_tq;
    private List<Map<String, Object>> data_list,data;
    private SimpleAdapter sim_adapter,adapter;

    // 图片封装为一个数组
    private int[] icon = { R.drawable.infor_img_tq1, R.drawable.infor_img_tq2,
            R.drawable.infor_img_tq3 };
    private String[] iconName = { "特权1", "特权2", "特权3" };


    private int[] icon_tq = {R.drawable.infor_img_tq4, R.drawable.infor_img_tq5,
            R.drawable.infor_img_tq6};
    private String[] iconName_tq = { "特权4", "特权5", "特权6"};

    public static TequanFragment newInstance() {

        Bundle args = new Bundle();

        TequanFragment fragment = new TequanFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragment_me_xinxi_tequan, null);
        initView(view);

        return view;
    }

    private void initView(View view) {
        gview = (GridView) view.findViewById(R.id.gview);
        gview_tq = (GridView) view.findViewById(R.id.gview_tq);
        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        data=new ArrayList<>();
        //获取数据
        getData();
        getDatatq();
        //新建适配器
        String [] from ={"image","text"};
        int [] to = {R.id.image,R.id.text};
        sim_adapter = new SimpleAdapter(getContext(), data_list, R.layout.item_xinxi_tequan, from, to);
        adapter=new SimpleAdapter(getContext(),data,R.layout.item_xinxi_tequan,from,to);
        //配置适配器
        gview.setAdapter(sim_adapter);
        gview_tq.setAdapter(adapter);
    }

    public List<Map<String, Object>> getData(){
        //cion和iconName的长度是相同的，这里任选其一都可以
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
            setAutoGridViewWidth();
        }

        return data_list;
    }


    /**
     *根据屏幕适配，动态设置GridVeiw的宽度。。。
     */
    private void setAutoGridViewWidth() {
        int size = data_list.size();
        Log.e("log", "GridView_Size:" + size);
        DisplayMetrics dm = new DisplayMetrics();
        int ScreeWidth = getActivity().getWindowManager().getDefaultDisplay().getWidth();//获取屏幕的宽度
        int itemWidth = (int) (ScreeWidth / 3.0);
        int allWidth = itemWidth * size;
        LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) gview.getLayoutParams();
        params.width=allWidth;
        params.height=LinearLayout.LayoutParams.FILL_PARENT;
        gview.setLayoutParams(params);
        gview.setColumnWidth(itemWidth);
        gview.setStretchMode(GridView.NO_STRETCH);
        gview.setNumColumns(size);
    }

    public List<Map<String, Object>> getDatatq(){
        //cion和iconName的长度是相同的，这里任选其一都可以
        for(int i=0;i<icon_tq.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon_tq[i]);
            map.put("text", iconName_tq[i]);
            data.add(map);
            setAutoGridViewWidth();
        }

        return data;
    }
}


