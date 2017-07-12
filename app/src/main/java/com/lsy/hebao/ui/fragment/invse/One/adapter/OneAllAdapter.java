package com.lsy.hebao.ui.fragment.invse.One.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lsy.hebao.R;
import com.lsy.hebao.ui.fragment.invse.One.model.OneAll;

import java.util.List;


public class OneAllAdapter extends BaseAdapter {
    private Context context;
    private List<OneAll.DataBean> list;

    public OneAllAdapter(Context context, List<OneAll.DataBean> mlist) {
        super();
        this.list = mlist;
        this.context = context;
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
        OneAllAdapter.ViewHodler hodler = null;
        if (convertView == null) {
            hodler = new OneAllAdapter.ViewHodler();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter_invse_one, null);
            hodler.timeTv = (TextView) convertView.findViewById(R.id.invest_item_title_one);
            ;
        } else {
            hodler = (OneAllAdapter.ViewHodler) convertView.getTag();
        }
        hodler.timeTv.setText(list.get(i).getProduct_name());
        convertView.setTag(hodler);
        return convertView;
    }

    class ViewHodler {
        private TextView timeTv;

    }
}
