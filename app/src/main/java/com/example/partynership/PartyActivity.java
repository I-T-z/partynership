package com.example.partynership;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class PartyActivity extends AppCompatActivity {
    private ListView partyboardlist;
    private List<PartyListItem> pList;
    com.example.partynership.PartyListAdapter pAdapter;
    ListView listView;
    PartyListAdapter adapter;
    CheckBox chbox;
    Button freebtn, partybtn, mentorbtn, writingbtn;

    Toolbar toolbar;
    ListView listview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party);

        //TODO 상단 버튼 바로 게시판 이동
        //TODO 어댑터 연결->리스트 보이기

        listView = findViewById(R.id.boardlist);
        //adapter = new PartyListAdapter();
        chbox = findViewById(R.id.checkbox);
        toolbar = findViewById(R.id.toolbar);
        listview = findViewById(R.id.boardlist);
        setSupportActionBar(toolbar);

        freebtn = findViewById(R.id.FreeBoard);
        partybtn = findViewById(R.id.PartyBoard);
        mentorbtn = findViewById(R.id.MentorBoard);

        //TODO: 커스텀 리스트 뷰
        // ListView참조 붙일 xml 명시
        partyboardlist = findViewById(R.id.boardlist);
        pList = generateItemsList();
        //어댑터 생성
        pAdapter = new com.example.partynership.PartyListAdapter(this, pList);

        // 어댑터 설정
        partyboardlist.setAdapter(pAdapter);

        // 데이터 변경 알림
        pAdapter.notifyDataSetChanged();
        //얘는 문제가 없음

        listView.setAdapter(pAdapter);

        Log.d("mytest", "파티호출");

        chbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("mytest", "onClick: 모집중인 글 보기");
            }
        });


        //TODO 게시글 작성 버튼 눌러서 게시물 작성 하는 페이지로 intent 이동하기
        //TODO 게시물 리스트 눌러서 해당 리스트 내용 불러 오기->방법 찾아 보기(데이터 연동)
        //TODO 모집 중인 글만 보는 라디오 버튼

        //TODO 여기 형식 가져다가 다른 액티비티에서 쓰기
        //TODO
        writingbtn = findViewById(R.id.btn);

        writingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartyActivity.this, NewPostParty.class);
                startActivity(intent);
            }
        });
        freebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartyActivity.this, FreeBoardActivity.class);
                startActivity(intent);
            }
        });

        partybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("mytesy", "파티");
                //intent는 각각 지역으로 선언해야함... 당연한 얘기임..근데 난 그렇게 안해서 코드 꼬였음..
                // intent전역으로 선언하지 마세염,,
                Intent intent = new Intent(PartyActivity.this, PartyActivity.class);
                startActivity(intent);
            }
        });


        mentorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartyActivity.this, MentorActivity.class);
                //intent.putExtra("item_name", );
                startActivity(intent);
                Log.d("mytest", "멘토게시판 호출");
            }
        });


        listview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent = new Intent(PartyActivity.this, PostParty.class);
                startActivity(intent);
                Log.d("mytest","게시글 선택");
                return true;
            }
        });


    }
    private List<PartyListItem> generateItemsList() {
        List<PartyListItem> pList = new ArrayList<>();
        pList.add(new PartyListItem("파티원 괌", "1/4", 33));

        return pList;
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
            Log.d("mytest", "홈아이콘 선택");
            Intent newActivity = new Intent(PartyActivity.this, MainActivity.class);
            startActivity(newActivity);
        } else if (item.getItemId() == R.id.profile) {
            Log.d("mytest", "프로필아이콘 선택");
            Intent newActivity = new Intent(PartyActivity.this, MyPageBoard.class);
            startActivity(newActivity);
        }
        return true;

    }
}