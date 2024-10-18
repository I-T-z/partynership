package com.example.partynership;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
public class GridAdapter extends BaseAdapter {


    private Context context;
    private List<com.example.partynership.GridItem> gList;
    public GridAdapter(Context _context, List<com.example.partynership.GridItem> _gList){
        context = _context;
        gList = _gList;
    }

    @Override
    public int getCount() {
        return gList.size();
    }

    @Override
    public Object getItem(int position) {
        return gList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.gridview_item_main, parent, false);
            holder = new ViewHolder();
            holder.gameImg = convertView.findViewById(R.id.gameImg);
            holder.gameName = convertView.findViewById(R.id.gameName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        com.example.partynership.GridItem gItem = gList.get(position);
        holder.gameImg.setImageResource(gItem.getImageResId());
        holder.gameName.setText(gItem.getGameName());

        return convertView;
    }
    private static class ViewHolder {
        ImageView gameImg;
        TextView gameName;
    }
}
