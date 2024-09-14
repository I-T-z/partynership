package com.example.partynership;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private ArrayAdapter adapter;
    private Spinner spinner;

    private String userNickName;
    private String userEmail;
    private String userGender;
    private String userPassword;
    private String checkPassword;
    private boolean validate=false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final ImageButton btnBack=findViewById(R.id.btnBack);
        final EditText etNickname = findViewById(R.id.etNickname);
        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etPassword = findViewById(R.id.etPassword);
        final EditText etCheckPw = findViewById(R.id.etEmail);
        final Button btnValidate = findViewById(R.id.btnValidate);

        spinner = findViewById(R.id.genderSpinner);
        adapter = ArrayAdapter.createFromResource(RegisterActivity.this, R.array.gender_array, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //뒤로가기 누르면 로그인 화면으로
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent=new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(Intent);
            }
        });

        //닉네임 작성 없이 중복 버튼 클릭 시
        btnValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userNickname = etNickname.getText().toString();

                if (userNickname.trim().equals("")) {
                    Toast.makeText(RegisterActivity.this, "닉네임을 입력해주세요", Toast.LENGTH_SHORT).show();
                    validate = false;
                    etNickname.setFocusable(true);
                    return;
                }
                if (validate) return;

                //TODO. 닉네임 중복 response
                //TODO. validate, queue 구문 추가
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 선택된 아이템의 문자열 값 가져오기
                String selectedItem = parent.getItemAtPosition(position).toString();

                // 문자열 값 처리 - 예: 선택된 값 로깅
                Log.d("Spinner", "Selected: " + selectedItem);

                // 선택된 값을 다른 처리에 사용할 수 있습니다.
                // 예를 들어, 유저가 '성별(선택)'을 선택했는지 아닌지를 검사하고
                // 올바른 선택을 유도할 수 있습니다.
                if (position > 0) {  // 첫 번째 아이템 '성별(선택)'은 제외하고 처리
                    // 선택된 성별에 따른 추가 로직 수행
                }
            }
            //스피너가 아무것도 선택되지 않았을 때
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                
            }
        });


        //회원가입 완료
        Button btnComplete = findViewById(R.id.btnComplete);
        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = etNickname.getText().toString();
                String userEMail = etEmail.getText().toString();
                String userPasswd = etPassword.getText().toString();
                String checkPassword = etCheckPw.getText().toString();

                //TODO. 유효 값에 따라 중복체크 요청 후 종료 처리

                //비밀번호와 비밀번호 확인값 같으면 그대로 처리, 다르면 토스트 메시지 출력
                if (userPassword != checkPassword) {
                    Toast.makeText(RegisterActivity.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                }

                //모든 항목이 채워져있지 않으면
                if (userNickName.equals("") || userEmail.equals("") || userPassword.equals("") || checkPassword.equals("")) {
                    Toast.makeText(RegisterActivity.this, "모든 정보를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }

                // TODO. response 데베 등록
            }
        });

        TextView gotoLogin=findViewById(R.id.gotoLogin);
        gotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}
