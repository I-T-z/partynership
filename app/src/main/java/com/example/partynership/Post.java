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
    TextView forward, title, content, datetime, mname;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        back = findViewById(R.id.back_button);
        forward = findViewById(R.id.forward_text);
        title = findViewById(R.id.title_text);
        content = findViewById(R.id.content_text);
        datetime = findViewById(R.id.datetime_text);
        mname = findViewById(R.id.mname_text);

        Intent intent = getIntent();
        // post_code를 Intent에서 가져오기
        String postCode = intent.getStringExtra("post_code");
        Log.d("postcode : ", postCode);

        if (postCode != null && !postCode.isEmpty()) {
            String url = "http://52.64.230.88:8080/partynership/get_post.jsp?post_code=" + postCode;

            RequestQueue queue = Volley.newRequestQueue(this);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                title.setText(response.getString("title"));
                                content.setText(response.getString("content"));
                                datetime.setText(response.getString("created_at"));
                                forward.setText(response.getString("forward"));
                                mname.setText(response.getString("memberName"));
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

            queue.add(jsonObjectRequest);
        }

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
