package com.example.partynership;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    ArrayList<ListItem> items = new ArrayList<>();
    Context context;

    public ListAdapter(Context _context) {
        context = _context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        //몇번째 리스트가 선택됐는지 확인하기
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        //그 선택된 리스트의 아이디를 가져오기
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext();
        ListItem listItem = items.get(position);

        if (convertView == null) {
            //context에서 layoutinflater를 가져오는 방법
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item_board, parent, false);
        }

        //화면에 보여질 데이터를 참조합니다.
        TextView subText = convertView.findViewById(R.id.list_subText);
        TextView numText = convertView.findViewById(R.id.numtext);

        //데이터를 set해줍니다.
        subText.setText(listItem.getSubText());
        numText.setText(listItem.getNumText());

        return convertView;
    }
}
