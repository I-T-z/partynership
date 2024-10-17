package com.example.partynership;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class Fragment3 extends Fragment {

    //멘토멘티 게시판 구현

    private ListView listView;
    private PartyListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        listView = view.findViewById(R.id.boardlist);

        // 어댑터 설정
        adapter = new PartyListAdapter(getContext(), generateItemsList());
        listView.setAdapter(adapter);

        return view;

    }

    private List<PartyListItem> generateItemsList() {
        List<PartyListItem> pList = new ArrayList<>();
        pList.add(new PartyListItem("멘티 모집합니다.", "0/1", 33));
        pList.add(new PartyListItem("멘티 모집합니다.", "0/1", 33));
        pList.add(new PartyListItem("멘티 모집합니다.", "0/1", 33));
        pList.add(new PartyListItem("멘티 모집합니다.", "0/1", 33));

        return pList;
    }
}