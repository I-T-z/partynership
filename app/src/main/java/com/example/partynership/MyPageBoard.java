package com.example.partynership;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MyPageBoard extends AppCompatActivity {
    Toolbar toolbar;
    ImageButton backbtn;
    Button board, tag;
    private ListView myBoardlist;
    MyBoardListAdapter mAdapter;
    private List<MyBoardListItem> mList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        backbtn = findViewById(R.id.back_button);
        board = findViewById(R.id.board);
        tag = findViewById(R.id.tag);


        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPageBoard.this, MyPageTag.class);
                startActivity(intent);
            }
        });
        //TODO: 커스텀 리스트 뷰
        // ListView참조 붙일 xml 명시
        myBoardlist = findViewById(R.id.my_list);
        mList = generateItemsList();
        //어댑터 생성
        mAdapter = new MyBoardListAdapter(this, mList);

        // 어댑터 설정
        myBoardlist.setAdapter(mAdapter);

        // 데이터 변경 알림
        mAdapter.notifyDataSetChanged();
        //얘는 문제가 없음

    }
    private List<MyBoardListItem> generateItemsList() {
        List<MyBoardListItem> mList = new ArrayList<>();
        mList.add(new MyBoardListItem("자랑", "가챠성공", "뭉가", "33","2024-01-29", "00:01:23","222"));

        return mList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.home) {
            Intent newActivity = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(newActivity);
        } else if (item.getItemId() == R.id.profile) {
            Intent newActivity = new Intent(getApplicationContext(), MyPageBoard.class);
            startActivity(newActivity);
        }
        return true;

    }
}
