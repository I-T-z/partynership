package com.example.partynership;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class NewPostParty extends AppCompatActivity {
    ArrayList<String> arrayList1, arrayList2;
    ArrayAdapter<String> arrayAdapter1, arrayAdapter2;
    Spinner approval, number;
    Button resbtn,register_button;
    ImageButton backbtn;
    Toolbar toolbar;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_party);

        resbtn = findViewById(R.id.register_button);
        backbtn = findViewById(R.id.back_button);
        approval = findViewById(R.id.approval_type_spinner);
        number=findViewById(R.id.number_of_people_spinner);
        register_button = findViewById(R.id.register_button);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewPostParty.this,PostParty.class);
                startActivity(intent);
                Log.d("post","party 넘어가기");
            }
        });

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        arrayList1 = new ArrayList<>();
        arrayList1.add("승인 형태");
        arrayList1.add("자동 승인");
        arrayList1.add("방장 승인");

        arrayList2 = new ArrayList<>();
        arrayList2.add("인원");
        arrayList2.add("1명");
        arrayList2.add("2명");
        arrayList2.add("3명");
        arrayList2.add("4명");

        arrayAdapter1 = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                arrayList1);

        arrayAdapter2 = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                arrayList2);

        approval.setAdapter(arrayAdapter1);
        number.setAdapter(arrayAdapter2);

        resbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //제목값과 내용값 가져와서 데이터에 저장시키기

            }
        });
        Log.d("mytesst","파티 화면 호출");

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            //    Intent intent = new Intent(NewPostMenti.this, MentorActivity.class);
              //  startActivity(intent);
            }
        });
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
            Intent newActivity = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(newActivity);
        } else if (item.getItemId() == R.id.profile) {
            Log.d("mytest", "프로필아이콘 선택");
            Intent newActivity = new Intent(getApplicationContext(), MyPageBoard.class);
            startActivity(newActivity);
        }
        return true;

    }
    //TODO 글 작성중 toolbar의 버튼을 눌렀을 시에 유효성 검사 -> 2학기
}
