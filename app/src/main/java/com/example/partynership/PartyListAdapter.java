package com.example.partynership;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class PartyListAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<PartyListItem> pList;

    public PartyListAdapter(Context context, List<com.example.partynership.PartyListItem> _pList) {
        this.pList = _pList;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return pList.size();
    }

    @Override
    public Object getItem(int position) {
        //몇번째 리스트가 선택됐는지 확인하기
        return pList.get(position);
    }

    @Override
    public long getItemId(int position) {
        //그 선택된 리스트의 아이디를 가져오기
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PartyListAdapter.ViewHolder holder;

        if (convertView == null) {
            //context에서 layoutinflater를 가져오는 방법

            convertView = inflater.inflate(R.layout.listview_item_board, parent, false);
            holder = new PartyListAdapter.ViewHolder();
            holder.subText = convertView.findViewById(R.id.list_subText);
            holder.numText = convertView.findViewById(R.id.numtext);
            convertView.setTag(holder);
        } else {
            holder = (PartyListAdapter.ViewHolder) convertView.getTag();
        }
        com.example.partynership.PartyListItem Item = pList.get(position);
        holder.subText.setText(Item.getSubText());
        holder.numText.setText(Item.getNumText());

        return convertView;
    }

    private static class ViewHolder {
        TextView subText;
        TextView numText;
    }
}
