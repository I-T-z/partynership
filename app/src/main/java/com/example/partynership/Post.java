package com.example.partynership;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class Post extends AppCompatActivity {
    Toolbar toolbar;
    ImageButton back;
    TextView forward, title, content, datetime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        back = findViewById(R.id.back_button);
        forward = findViewById(R.id.forward);
        title = findViewById(R.id.textViewTitle);
        content = findViewById(R.id.content_text);
        datetime = findViewById(R.id.datetime_text);

        Intent intent = getIntent();
        // intent 값 가져옴
        String sforward = intent.getStringExtra("forward");
        String stitle = intent.getStringExtra("title");
        String scontent = intent.getStringExtra("content");
        String sdatetime = intent.getStringExtra("datetime");

        forward.setText(sforward);
        title.setText(stitle);
        content.setText(scontent);
        datetime.setText(sdatetime);

        // RequestQueue 초기화
        RequestQueue queue = Volley.newRequestQueue(this);

        // 요청할 URL
        //TODO: post_id 받아오는 것 구현 (임시로 1로 설정해둠)
        String url = "http://112.175.185.136:8080/Partynership/Partynership.jsp?post_id=1";

        // JSON 요청 생성
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //서버로부터 데이터 가져와서 TextView에 설정
                            title.setText(response.getString("title"));
                            content.setText(response.getString("content"));
                            datetime.setText(response.getString("created_at"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("PostActivity", "Error fetching data: " + error.getMessage());
                    }
                });

        // 요청을 큐에 추가
        queue.add(jsonObjectRequest);

        Intent gitent = getIntent();

        forward.setText("["+gitent.getStringExtra("forward")+"]");
        title.setText(gitent.getStringExtra("title"));
        content.setText(gitent.getStringExtra("content"));
        datetime.setText(gitent.getStringExtra("datetime"));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Post.this, MBoardActivity.class);
                intent.putExtra("fragmentkey",0);
                startActivity(intent);

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
