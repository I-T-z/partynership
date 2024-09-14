package com.example.partynership;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TagListAdapter extends BaseAdapter {
    ArrayList<TagListItem> items = new ArrayList<>();
    Context context;

    public TagListAdapter(Context _context) {
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
        TagListItem listItem = items.get(position);

        if (convertView == null) {
            //context에서 layoutinflater를 가져오는 방법
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item_mypage2, parent, false);
        }

        //화면에 보여질 데이터를 참조합니다.
        TextView name = convertView.findViewById(R.id.tag_name);
        TextView tagcontent = convertView.findViewById(R.id.tag_content);

        //데이터를 set해줍니다.
        name.setText(listItem.getName());
        tagcontent.setText(listItem.getTagcontent());

        return convertView;

    }
    public void addItem(TagListItem item){
        items.add(item);}
}

