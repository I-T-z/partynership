package com.example.partynership;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {

//파티게시판 구현

    private ListView listView;
    private  PartyListAdapter adapter;
    Button wtnbtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        listView = view.findViewById(R.id.boardlist);
        wtnbtn = view.findViewById(R.id.writing_btn);
        // 어댑터 설정
        adapter = new  PartyListAdapter(getContext(), generateItemsList());
        listView.setAdapter(adapter);

        wtnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NewPostFree.class);
                startActivity(intent);
            }
        });


        return view;

    }
    private List<PartyListItem> generateItemsList() {
        List<PartyListItem> pList = new ArrayList<>();
        pList.add(new PartyListItem("파티원 괌", "1/4", 33));
        pList.add(new PartyListItem("파티원 괌", "1/4", 33));
        pList.add(new PartyListItem("파티원 괌", "1/4", 33));
        pList.add(new PartyListItem("파티원 괌", "1/4", 33));

        return pList;
    }
}