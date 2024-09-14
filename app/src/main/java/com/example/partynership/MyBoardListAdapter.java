package com.example.partynership;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MyBoardListAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<MyBoardListItem> mList;

    public MyBoardListAdapter(Context context, List<MyBoardListItem> _mList) {
        this.mList = _mList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            //context에서 layoutinflater를 가져오는 방법

            convertView = inflater.inflate(R.layout.listview_item_mypage1, parent, false);
            holder = new ViewHolder();
            holder.forward = convertView.findViewById(R.id.free_forward);
            holder.subTitle = convertView.findViewById(R.id.free_subTitle);
            holder.memName = convertView.findViewById(R.id.free_memName);
            holder.riple = convertView.findViewById(R.id.free_riple);
            holder.freeDate = convertView.findViewById(R.id.free_date);
            holder.freeTime = convertView.findViewById(R.id.free_time);
            holder.likenum = convertView.findViewById(R.id.likenum);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        MyBoardListItem mItem = mList.get(position);
        holder.forward.setText(mItem.getForward());
        holder.subTitle.setText(mItem.getSubTitle());
        holder.memName.setText(mItem.getMemName());
        holder.riple.setText(mItem.getRiple());
        holder.freeDate.setText(mItem.getFreeDate());
        holder.freeDate.setText(mItem.getFreeDate());
        holder.likenum.setText(mItem.getLikenum());

        return convertView;
    }

    private static class ViewHolder {
        TextView forward;
        TextView subTitle;
        TextView memName;
        TextView riple;
        TextView freeDate;
        TextView freeTime;
        TextView likenum;

    }
}
