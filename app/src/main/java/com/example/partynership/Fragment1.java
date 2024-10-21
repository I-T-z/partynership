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

//자유게시판 구현

public class Fragment1 extends Fragment {

    private ListView listView;
    private FreeListAdapter adapter;
    Button wtnbtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        listView = view.findViewById(R.id.free_boardlist);
        wtnbtn = view.findViewById(R.id.writing_btn);

        // 어댑터 설정
        adapter = new FreeListAdapter(getContext(), generateItemsList());
        listView.setAdapter(adapter);

        //게시물 작성 버튼 누르기
        wtnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //어느 게시판에서 넘어갔는지에 따라 나타나는 작성창 형식 다름
                Intent intent = new Intent(getActivity(), NewPostFree.class);
                intent.putExtra("boardname","자유게시판");
                startActivity(intent);
            }
        });

        return view;




    }
    private List<FreeListItem> generateItemsList() {
        List<FreeListItem> fList = new ArrayList<>();
        fList.add(new FreeListItem("[자랑]", "가챠성공", "뭉가", "2024-01-29", "00:01:23"));
        fList.add(new FreeListItem("[자랑]", "가챠성공", "뭉가", "2024-01-29", "00:01:23"));
        fList.add(new FreeListItem("[자랑]", "가챠성공", "뭉가", "2024-01-29", "00:01:23"));
        fList.add(new FreeListItem("[자랑]", "가챠성공", "뭉가", "2024-01-29", "00:01:23"));

        return fList;
    }

}