package com.example.partynership;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class FreeBoardActivity extends AppCompatActivity {
    private ListView freeboardlist;
    private List<com.example.partynership.FreeListItem> fList;
    com.example.partynership.FreeListAdapter fAdapter;
    Button freebtn, partybtn, mentorbtn, writingbtn;

    Intent intent;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_board); // 레이아웃 설정


        //TODO: 버튼 누르면 해당하는 엑티비티로 이동하기
        freebtn = findViewById(R.id.FreeBoard);
        partybtn = findViewById(R.id.PartyBoard);
        mentorbtn = findViewById(R.id.MentorBoard);
        writingbtn = findViewById(R.id.writing_btn);
        listView = findViewById(R.id.free_boardlist);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        writingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FreeBoardActivity.this, NewPostFree.class);
                startActivity(intent);
            }
        });

        freebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FreeBoardActivity.this, FreeBoardActivity.class);
                startActivity(intent);
            }
        });

        partybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // intent전역으로 선언하지 마세염,,
                Intent intent = new Intent(FreeBoardActivity.this, PartyActivity.class);
                startActivity(intent);
                Log.d("mytest", "파티");
            }
        });

        mentorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(FreeBoardActivity.this, com.example.partynership.MentorActivity.class);
                //intent.putExtra("item_name", );
                startActivity(intent);
                Log.d("mytest", "멘토게시판 호출");
            }
        });

        //TODO: 커스텀 리스트 뷰
        // ListView참조 붙일 xml 명시
        freeboardlist = findViewById(R.id.free_boardlist);
        //fList = generateItemsList();
        //어댑터 생성
        fAdapter = new com.example.partynership.FreeListAdapter(this, fList);

        // 어댑터 설정
        freeboardlist.setAdapter(fAdapter);

        // 데이터 변경 알림
        fAdapter.notifyDataSetChanged();
        //얘는 문제가 없음

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //해당하는 페이지로 가도록 설계해야함
                Intent intent = new Intent(FreeBoardActivity.this, Post.class);
                startActivity(intent);
                Log.d("mytest","게시글 선택");
            }
        });

    }

    private List<FreeListItem> generateItemsList() {
        List<FreeListItem> fList = new ArrayList<>();
        fList.add(new FreeListItem("[자랑]", "가챠성공", "뭉가", "2024-01-29 00:01:23"));
        fList.add(new FreeListItem("[자랑]", "가챠성공", "뭉가", "2024-01-29 00:01:23"));
        fList.add(new FreeListItem("[자랑]", "가챠성공", "뭉가", "2024-01-29 00:01:23"));
        fList.add(new FreeListItem("[자랑]", "가챠성공", "뭉가", "2024-01-29 00:01:23"));

        return fList;
    }

    //menu resource 내용을 toolbar에 반영
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    //툴바에 표시된 액션 또는 오버플로우 메뉴가 선택되면 액티비티의 onOptionsItemSelected() 메소드가 호출
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.home) {
            Intent newActivity = new Intent(FreeBoardActivity.this, MainActivity.class);
            startActivity(newActivity);
        } else if (item.getItemId() == R.id.profile) {
            Intent newActivity = new Intent(FreeBoardActivity.this, MyPageBoard.class);
            startActivity(newActivity);
        }
        return true;

    }
}
