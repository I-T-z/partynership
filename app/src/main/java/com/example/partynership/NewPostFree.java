package com.example.partynership;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import java.util.Locale;


public class NewPostFree extends AppCompatActivity {
    String title, content, link, datetime;
    Button resbtn, linkbtn;
    ImageButton cancelbtn;
    ImageButton backbtn;
    Spinner fowardspn, selectboard, approvalspn1, numberspn1, approvalspn2, numberspn2;
    EditText tagedt, contenttxt, titletxt, linkedt;
    TextView linktxt;
    ViewFlipper linkvf, spinnerGp;
    SimpleDateFormat sdf;
    RadioGroup rdg;
    RadioButton rdmto, rdmtee;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_free);

        resbtn = findViewById(R.id.register_button);
        backbtn = findViewById(R.id.cancle_button);
        linkbtn = findViewById(R.id.link_confirm_button);
        cancelbtn = findViewById(R.id.cancel_btn);
        linkvf = findViewById(R.id.link_vf);
        spinnerGp = findViewById(R.id.spinnerGP);
        fowardspn = findViewById(R.id.free_forward);
        selectboard = findViewById(R.id.select_borad);
        approvalspn1 = findViewById(R.id.approval_type_spinner1);
        numberspn1 = findViewById(R.id.number_of_people_spinner1);
        approvalspn2 = findViewById(R.id.approval_type_spinner2);
        numberspn2 = findViewById(R.id.number_of_people_spinner2);
        rdg = findViewById(R.id.rdg);
        rdmto = findViewById(R.id.rdmto);
        rdmtee = findViewById(R.id.rdmtee);
        ViewGroup.LayoutParams params = linkvf.getLayoutParams();


        //TODO: 게시판 선택 스피너 연결
        //  --> 각 게시판에서 작성화면으로 intent보낼때 일정 코드 같이 보내서 선택하지 않아도 해당 화면 띄우게 설계 필요
        String[] selectitems = {"[게시판선택]", "자유게시판", "파티게시판", "멘토/멘티게시판"};
        ArrayAdapter<String> adapterselect = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, selectitems);
        //항목 레이아웃 설정
        adapterselect.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 설정
        selectboard.setAdapter(adapterselect);

        //TODO: 게시판 선택 리스너 설정
        selectboard.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {//자유게시판 선택
                    spinnerGp.setDisplayedChild(0);
                    //링크작성칸을 없애기 위해 크기 자체를 0으로 만들기
                    params.width = 0;
                    params.height = 0;
                } else if (position == 2) { //파티게시판 선택
                    spinnerGp.setDisplayedChild(1);
                    params.width = ViewGroup.LayoutParams.MATCH_PARENT;
                    params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                } else if (position == 3) { //멘토멘티 선택
                    spinnerGp.setDisplayedChild(2);
                    params.width = ViewGroup.LayoutParams.MATCH_PARENT;
                    params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                }
                linkvf.setLayoutParams(params);
                linkvf.requestLayout();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //일정 코드 저장해서 저장버튼 누를 때 알림창 띄우도록 설계
            }
        });

        //TODO: 어떤 게시판 창에서 넘어왔는지 확인하기
        Intent intent = getIntent();
        // intent 값 가져옴
        String boardname = intent.getStringExtra("boardname");

        if (boardname != null) { // null 체크
            if (boardname.equals("자유게시판")) { // 자유게시판 선택
                // 첫번째 스피너 값 지정하기
                selectboard.setSelection(1);
            } else if (boardname.equals("파티게시판")) { // 파티게시판 선택
                selectboard.setSelection(2);
            } else if (boardname.equals("멘토/멘티게시판")) { // 멘토멘티 선택
                selectboard.setSelection(3);
            }
        } else {
            //기본 값 선택
            selectboard.setSelection(0);
        }
        //TODO: [자유게시판] 말머리 선택 스피너 연결
        String[] items = {"[말머리]", "자유", "자랑"};
        // ArrayAdapter 생성 (Context, 레이아웃, 데이터 배열)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        //항목 레이아웃 설정
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 설정
        fowardspn.setAdapter(adapter);
        //사용자가 말머리 선택안해서 스피너가 [말머리]라고 선택되어있다면 저장 안하게 하기

        //TODO: [파티-멘토/멘티]승인형태 스피너 연결
        String[] approvalitems = {"승인방법", "자동승인", "확인승인"};
        // ArrayAdapter 생성 (Context, 레이아웃, 데이터 배열)
        ArrayAdapter<String> aproveadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, approvalitems);
        //항목 레이아웃 설정
        aproveadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 설정
        approvalspn1.setAdapter(aproveadapter);
        approvalspn2.setAdapter(aproveadapter);
        //사용자가 말머리 선택안해서 스피너가 [말머리]라고 선택되어있다면 저장 안하게 하기
        //TODO: [파티-멘토/멘티]신청인원 스피너 연결
        String[] membitems = {"인원", "1", "2", "3", "4"};
        //--> TODO:멘토멘티에서 인원 선택 시 위 배열 요소를 2번째 까지만 출력해야함
        // ArrayAdapter 생성 (Context, 레이아웃, 데이터 배열)
        ArrayAdapter<String> membadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, membitems);
        //항목 레이아웃 설정
        membadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 설정
        numberspn1.setAdapter(membadapter);
        numberspn2.setAdapter(membadapter);
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
                linkvf.setDisplayedChild(1);
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
                linkvf.setDisplayedChild(2);
            }
        });

        resbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 현재 날짜와 시간 가져오기 (DATETIME 형식으로 저장)
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREAN);
                datetime = sdf.format(System.currentTimeMillis());
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
                SavePostRequest SPRequest = new SavePostRequest(datetime, title, content, link, responseListener);
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

}
