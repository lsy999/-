package com.lsy.hebao.ui.fragment.invse.Two.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.lsy.hebao.R;
import com.lsy.hebao.ui.fragment.invse.Two.model.TwoAll;

import java.util.List;

/**
 * Created by lsy on 2017/4/13.
 */

public class TwoAllAdapter extends BaseAdapter {
    private List<TwoAll.DataBean> list;

    public TwoAllAdapter(List<TwoAll.DataBean> mlist) {
        super();
        this.list = mlist;
    }

    @Override
    public int getCount() {
        if (list != null && list.size() > 0) {
        } else {
        }
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        if (list != null && list.size() > 0) {
            return list.get(i);
        } else {
            return null;
        }

    }


    @Override
    public long getItemId(int i) {
        if (list != null && list.size() > 0) {
            return i;
        } else {
            return 0;
        }
    }


    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHodler hodler = null;
        if (convertView == null) {
            hodler = new ViewHodler();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter_invse_two, null);
            hodler.timeTv = (TextView) convertView.findViewById(R.id.invest_item_title_two);;
        } else {
            hodler = (ViewHodler) convertView.getTag();
        }
        hodler.timeTv.setText(list.get(i).getProduct_name());
        convertView.setTag(hodler);
        return convertView;
    }

    class ViewHodler {
        private TextView timeTv;

    }
}