package com.lsy.hebao.ui.fragment.me.xinxi.renwu;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.lsy.hebao.R;
import com.lsy.hebao.base.BaseFragment;
import com.lsy.hebao.base.MvpFragment;
import com.lsy.hebao.ui.fragment.invse.One.OneFragment;
import com.lsy.hebao.ui.fragment.invse.One.model.OneAll;
import com.lsy.hebao.ui.fragment.invse.One.presenter.OnePresenter;
import com.lsy.hebao.ui.fragment.invse.One.view.IOneView;

import java.util.ArrayList;
import java.util.List;

import lib.view.listview.AnimatedExpandableListView;

/**
 * Created by lsy on 2017/4/24.
 */

public class RenwuFragment extends BaseFragment {

    private AnimatedExpandableListView listView;
    private ExampleAdapter adapter;

    public static RenwuFragment newInstance() {

        Bundle args = new Bundle();

        RenwuFragment fragment = new RenwuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragment_me_xinxi_renwu, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        List<GroupItem> items = new ArrayList<GroupItem>();

        for (int i = 1; i < 10; i++) {
            GroupItem item = new GroupItem();

            item.title = "新用户成功绑卡 " + i;

                ChildItem child = new ChildItem();
                child.title = "成长值+1 体验金+1000 "+i;

                item.items.add(child);

            items.add(item);
        }

        adapter = new ExampleAdapter(getActivity());
        adapter.setData(items);

        listView = (AnimatedExpandableListView) view.findViewById(R.id.listView);
        listView.setGroupIndicator(null);
        listView.setAdapter(adapter);

        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if (listView.isGroupExpanded(groupPosition)) {
                    listView.collapseGroupWithAnimation(groupPosition);
                } else {
                    listView.expandGroupWithAnimation(groupPosition);
                }
                return true;
            }
        });
    }


    private static class GroupItem {
        String title;
        List<ChildItem> items = new ArrayList<ChildItem>();
    }

    private static class ChildItem {
        String title;
    }

    private static class ChildHolder {
        TextView title;
    }

    private static class GroupHolder {
        TextView title;
    }

    /**
     * Adapter for our list of {@link GroupItem}s.
     */
    private class ExampleAdapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter {
        private LayoutInflater inflater;

        private List<GroupItem> items;

        public ExampleAdapter(Context context) {
            inflater = LayoutInflater.from(context);
        }

        public void setData(List<GroupItem> items) {
            this.items = items;
        }

        @Override
        public ChildItem getChild(int groupPosition, int childPosition) {
            return items.get(groupPosition).items.get(childPosition);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public View getRealChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            ChildHolder holder;
            ChildItem item = getChild(groupPosition, childPosition);
            if (convertView == null) {
                holder = new ChildHolder();
                convertView = inflater.inflate(R.layout.item_me_xinxi_renwu_liao, parent, false);
                holder.title = (TextView) convertView.findViewById(R.id.text_renwu);
                convertView.setTag(holder);
            } else {
                holder = (ChildHolder) convertView.getTag();
            }

            holder.title.setText(item.title);

            return convertView;
        }

        @Override
        public int getRealChildrenCount(int groupPosition) {
            return items.get(groupPosition).items.size();
        }

        @Override
        public GroupItem getGroup(int groupPosition) {
            return items.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            return items.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            GroupHolder holder;
            GroupItem item = getGroup(groupPosition);
            if (convertView == null) {
                holder = new GroupHolder();
                convertView = inflater.inflate(R.layout.item_me_xinixi_renwu, parent, false);
                holder.title = (TextView) convertView.findViewById(R.id.text_missionTitle);
                convertView.setTag(holder);
            } else {
                holder = (GroupHolder) convertView.getTag();
            }

            holder.title.setText(item.title);

            return convertView;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public boolean isChildSelectable(int arg0, int arg1) {
            return true;
        }

    }
}


