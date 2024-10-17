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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;


public class NewPostFree extends AppCompatActivity {
    Button resbtn;
    ImageButton backbtn;
    Toolbar toolbar;
    Spinner fowardspn;
    EditText tagedt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_free);

        resbtn = findViewById(R.id.register_button);
        backbtn = findViewById(R.id.back_button);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //스피너 연결
        fowardspn = findViewById(R.id.free_forward);
        String[] items = {"[말머리]","자유","자랑","","",""};
        // ArrayAdapter 생성 (Context, 레이아웃, 데이터 배열)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        //항목 레이아웃 설정
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 설정
        fowardspn.setAdapter(adapter);
        //사용자가 말머리 선택안해서 스피너가 [말머리]라고 선택되어있다면 저장 안하게 하기


        resbtn.setOnClickListener(new View.OnClickListener() {
            //여기에 db연동해서 저장하는 작업 실행
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Log.d("mytesst","멘티 화면 호출");
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }@Override
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
