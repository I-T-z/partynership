package com.example.partynership;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MyFragment2 extends Fragment {
    private ListView listView;
    private MyBoardListAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my1, container, false);
        listView = view.findViewById(R.id.my_list);

        adapter = new MyBoardListAdapter(getContext(), generateItemsList());
        listView.setAdapter(adapter);

        return view;
    }
    //다른 리스트item을 쓰던가... 좀 바꿔야할듯

    private List<MyBoardListItem> generateItemsList() {
        List<MyBoardListItem> mList = new ArrayList<>();
        mList.add(new MyBoardListItem("후기", "정말 재밌어요!", "사용자A", "45", "2024-01-30", "00:15:00", "333"));
        mList.add(new MyBoardListItem("후기", "정말 재밌어요!", "사용자A", "45", "2024-01-30", "00:15:00", "333"));
        mList.add(new MyBoardListItem("후기", "정말 재밌어요!", "사용자A", "45", "2024-01-30", "00:15:00", "333"));
        return mList;
    }
}