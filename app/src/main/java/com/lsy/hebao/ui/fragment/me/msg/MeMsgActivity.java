package com.lsy.hebao.ui.fragment.me.msg;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lsy.hebao.R;

import lib.view.card.TurnCardListView;

public class MeMsgActivity extends Activity {
    TurnCardListView cardList;
    ImageView imgTopback;
    RelativeLayout relGolast;
    private int currentposition;//当前显示的是第几个
    ImageView img_topback;
    RelativeLayout rel_golast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_msg);
        initView();
        initDate();
    }

    private void initView() {
        cardList= (TurnCardListView) findViewById(R.id.card_list);
        imgTopback= (ImageView) findViewById(R.id.img_topback);
        relGolast= (RelativeLayout) findViewById(R.id.rel_golast);
        img_topback = (ImageView) findViewById(R.id.img_topback);
        rel_golast= (RelativeLayout) findViewById(R.id.rel_golast);
    }

    private void initDate() {


        //前台展示的是哪个
        cardList.setOnTurnListener(new TurnCardListView.OnTurnListener() {
            @Override
            public void onTurned(int position) {
                currentposition=position;
                if (0 == position) {
                    //当前的是最新的
                    relGolast.setVisibility(View.GONE);
                } else {
                    relGolast.setVisibility(View.VISIBLE);
                }
            }
        });


        cardList.setAdapter(new BaseAdapter() {
            int[] colors = {0xffFF9800, 0xff3F51B5, 0xff673AB7, 0xff006064, 0xffC51162, 0xffFFEB3B, 0xff795548, 0xff9E9E9E};

            @Override
            public int getCount() {
                return colors.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View child, ViewGroup parent) {
                if (child == null) {
                    child = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_msg_adapter_item, parent, false);
                }

                ((TextView) child.findViewById(R.id.pos)).setText(String.valueOf(position));
                child.findViewById(R.id.image).setBackgroundColor(colors[position]);
                return child;
            }
        });

        img_topback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        rel_golast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //回到最新的
                int size = currentposition;
                while (size > 0) {
                    cardList.turnBy(-1);
                    size--;
                }
            }
        });


    }
}
