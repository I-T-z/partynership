package com.example.partynership;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
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
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class NewPostFree extends AppCompatActivity {
    String title, content, link,Date,Time;
    Button resbtn, linkbtn, linkmodibtn;
    ImageButton cancelbtn;
    ImageButton backbtn;
    Toolbar toolbar;
    Spinner fowardspn;
    EditText tagedt, contenttxt, titletxt, linkedt;
    TextView linktxt;
    ViewFlipper vf;
    SimpleDateFormat sdf;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_free);

        resbtn = findViewById(R.id.register_button);
        backbtn = findViewById(R.id.back_button);
        linkbtn = findViewById(R.id.link_confirm_button);
        cancelbtn = findViewById(R.id.cancel_btn);
        vf = findViewById(R.id.link_vf);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TODO: 스피너 연결 --> 말머리 내용
        fowardspn = findViewById(R.id.free_forward);
        String[] items = {"[말머리]", "자유", "자랑"};
        // ArrayAdapter 생성 (Context, 레이아웃, 데이터 배열)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        //항목 레이아웃 설정
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 설정
        fowardspn.setAdapter(adapter);
        //사용자가 말머리 선택안해서 스피너가 [말머리]라고 선택되어있다면 저장 안하게 하기

        //TODO: 저장할만한 내용
        titletxt = findViewById(R.id.title_text);
        contenttxt = findViewById(R.id.content_text);
        linkedt = findViewById(R.id.link_edt);
        linktxt = findViewById(R.id.link_text);
        tagedt = findViewById(R.id.tag_text);

        //링크 버튼 눌렀을 때 하이퍼 링크로 바꾸기
        linkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = linkedt.getText().toString().trim(); //사용자가 입력한 link를 string으로 저장
                vf.setDisplayedChild(1);
                // URL 형식이 맞는지 확인
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = url;
                    //   url = "http://" + url;
                }

                // TextView에 하이퍼링크 표시
                linktxt.setText(url);
                linktxt.setMovementMethod(LinkMovementMethod.getInstance());
            }
        });
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linktxt.setText("");
                vf.setDisplayedChild(2);
            }
        });

        resbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 현재 날짜와 시간 가져오기
                sdf = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREAN);
                Date = sdf.format (System.currentTimeMillis());
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.KOREAN);
                Time = sdf.format (System.currentTimeMillis());
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                title = jsonResponse.getString("titletxt");
                                content = jsonResponse.getString("contexttxt");
                                link = jsonResponse.getString("linkedt");
                            } else {
                                // 실패 처리
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };

                // 넘길거 -> 현재 날짜와 시간을 추가
                SavePostRequest SPRequest = new SavePostRequest(Date,Time, title, content, link, responseListener);
                RequestQueue queue = Volley.newRequestQueue(v.getContext());
                queue.add(SPRequest);
            }
        });

        Log.d("mytesst", "멘티 화면 호출");
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
            Intent newActivity = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(newActivity);
        } else if (item.getItemId() == R.id.profile) {
            Intent newActivity = new Intent(getApplicationContext(), MyPageBoard.class);
            startActivity(newActivity);
        }
        return true;

    }


}
