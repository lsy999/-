package com.lsy.hebao.ui.fragment.me.xinxi.tequan.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lsy.hebao.R;

import java.util.ArrayList;

/**
 * Created by lsy on 2017/4/25.
 */

public class PutongAdapter extends RecyclerView.Adapter<PutongAdapter.ViewHolder>{

    private ArrayList<String> mData;

    public PutongAdapter(ArrayList<String> data) {
        this.mData = data;
    }

    public void updateData(ArrayList<String> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 实例化展示的view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_xinxi_tequan, parent, false);
        // 实例化viewholder
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // 绑定数据
        //holder.mTv.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mTv;

        public ViewHolder(View itemView) {
            super(itemView);
            mTv = (ImageView) itemView.findViewById(R.id.iv_tequan);
        }
    }
}