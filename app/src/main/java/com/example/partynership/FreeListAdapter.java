package com.example.partynership;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class FreeListAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<com.example.partynership.FreeListItem> fList;

    public FreeListAdapter(Context context, List<com.example.partynership.FreeListItem> _fList) {
        this.fList = _fList;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return fList.size();
    }

    @Override
    public Object getItem(int position) {
        return fList.get(position);
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
            
            convertView = inflater.inflate(R.layout.listview_item_free, parent, false);
            holder = new ViewHolder();
            holder.forward = convertView.findViewById(R.id.free_forward);
            holder.subTitle = convertView.findViewById(R.id.free_subTitle);
            holder.memName = convertView.findViewById(R.id.free_memName);
<<<<<<< HEAD
            holder.freeDatetime = convertView.findViewById(R.id.free_datetime);
=======
            holder.freeDateTime = convertView.findViewById(R.id.free_date_time);
>>>>>>> origin/hyen
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        com.example.partynership.FreeListItem fItem = fList.get(position);
        holder.forward.setText(fItem.getForward());
        holder.subTitle.setText(fItem.getSubTitle());
        holder.memName.setText(fItem.getMemName());
<<<<<<< HEAD
        holder.freeDatetime.setText(fItem.getFreeDatetime());
=======
        holder.freeDateTime.setText(fItem.getfreeDateTime());
>>>>>>> origin/hyen

        return convertView;
    }

    private static class ViewHolder {
        TextView forward;
        TextView subTitle;
        TextView memName;
<<<<<<< HEAD
        TextView freeDatetime;
=======
        TextView freeDateTime;
>>>>>>> origin/hyen
    }
}
