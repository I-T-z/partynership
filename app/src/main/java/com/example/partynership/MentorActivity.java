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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MentorActivity extends AppCompatActivity {
    ArrayList<String> arrayList1;
    ArrayAdapter<String> arrayAdapter1;
    ListView listView;
    private ListView partyboardlist;
    private List<PartyListItem> pList;
    com.example.partynership.PartyListAdapter pAdapter;
    ImageButton back;
    Button freebtn, partybtn, mentorbtn, postbtn;
    Toolbar toolbar;
    CheckBox mentor_mentee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.boardlist);

        back = findViewById(R.id.back_button);
        freebtn = findViewById(R.id.FreeBoard);
        partybtn = findViewById(R.id.PartyBoard);
        mentorbtn = findViewById(R.id.MentorBoard);
        mentor_mentee = findViewById(R.id.checkbox);

        arrayList1 = new ArrayList<>();
        arrayList1.add("멘토");
        arrayList1.add("멘티");

        arrayAdapter1 = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                arrayList1);

       // mentor_mentee.setAdapter(arrayAdapter1);

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

        postbtn = findViewById(R.id.btn);


        postbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("mytest", "화면 불러오기");
                Intent intent = new Intent(MentorActivity.this, NewPostMenti.class);
                startActivity(intent);
            }
        });
        freebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MentorActivity.this, FreeBoardActivity.class);
                startActivity(intent);
            }
        });

        partybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("mytesy", "파티");
                //intent는 각각 지역으로 선언해야함... 당연한 얘기임..근데 난 그렇게 안해서 코드 꼬였음..
                // intent전역으로 선언하지 마세염,,
                Intent intent = new Intent(MentorActivity.this, PartyActivity.class);
                startActivity(intent);
            }
        });
        mentorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MentorActivity.this, MentorActivity.class);
                //intent.putExtra("item_name", );
                startActivity(intent);
                Log.d("mytest", "멘토게시판 호출");
            }
        });
        //지시한 내용과 방향이 맞는지 체크 필요함, 중간에 중간 보고

        listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent = new Intent(MentorActivity.this, PostMentor.class);
                startActivity(intent);
                Log.d("mytest","게시글 선택");
                return true;
            }
        });


    }

    private List<PartyListItem> generateItemsList() {
        List<PartyListItem> pList = new ArrayList<>();
        pList.add(new PartyListItem("멘티 모집합니다.", "0/1", 33));

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
            Intent newActivity = new Intent(MentorActivity.this, MainActivity.class);
            startActivity(newActivity);
        } else if (item.getItemId() == R.id.profile) {
            Intent newActivity = new Intent(MentorActivity.this, MyPageBoard.class);
            startActivity(newActivity);
        }
        return true;

    }
}