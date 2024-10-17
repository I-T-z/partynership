package com.example.partynership;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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
            // LayoutInflater로 새 뷰를 인플레이트
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
        // 각 뷰에 데이터를 설정
        holder.forward.setText(mItem.getForward());             // 제목
        holder.subTitle.setText(mItem.getSubTitle());           // 게시물 제목
        holder.memName.setText(mItem.getMemName());             // 작성자 이름
        holder.riple.setText(mItem.getRiple());                 // 댓글 수
        holder.freeDate.setText(mItem.getFreeDate());           // 날짜
        holder.freeTime.setText(mItem.getFreeTime());           // 시간
        holder.likenum.setText(mItem.getLikenum());             // 좋아요 수

        return convertView;
    }

    private static class ViewHolder {
        TextView forward;      // 말머리
        TextView subTitle;     // 게시물 제목
        TextView memName;      // 작성자 이름
        TextView riple;        // 댓글 수
        TextView freeDate;     // 날짜
        TextView freeTime;     // 시간
        TextView likenum;      // 좋아요 수
    }
}
