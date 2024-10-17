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


public class MyFragment1 extends Fragment {

    private ListView listView;
    private MyBoardListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my1, container, false);
        listView = view.findViewById(R.id.my_list);

        // 어댑터 설정
        adapter = new MyBoardListAdapter(getContext(), generateItemsList());
        listView.setAdapter(adapter);

        return view;
    }

    private List<MyBoardListItem> generateItemsList() {
        List<MyBoardListItem> mList = new ArrayList<>();
        mList.add(new MyBoardListItem("자랑", "가챠성공", "작성자", "33", "2024-01-29", "00:01:23", "222"));
        mList.add(new MyBoardListItem("자랑", "가챠성공", "작성자", "33", "2024-01-29", "00:01:23", "222"));
        mList.add(new MyBoardListItem("자랑", "가챠성공", "작성자", "33", "2024-01-29", "00:01:23", "222"));
        mList.add(new MyBoardListItem("자랑", "가챠성공", "작성자", "33", "2024-01-29", "00:01:23", "222"));
        return mList;
    }
}