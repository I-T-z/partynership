package com.example.partynership;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class PostMentor extends AppCompatActivity {
    Toolbar toolbar;
    ImageButton back;
    TextView title, datetime,content,link,approval;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_menti);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        back = findViewById(R.id.back_button);
        title = findViewById(R.id.textViewTitle);
        datetime = findViewById(R.id.datetime_text);
        content = findViewById(R.id.content_text);
        link = findViewById(R.id.link_text);
        //approval = findViewById(R.id.approval_text);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PostMentor.this, MBoardActivity.class);
                intent.putExtra("fragmentkey",2);
                startActivity(intent);
            }
        });


        //보낸 인텐드 받아오기
        Intent gitent = getIntent();
        String sapprove = gitent.getStringExtra("approval");
        String snumber = gitent.getStringExtra("number");
        String sdatetime = gitent.getStringExtra("datetime");
        String stitle = gitent.getStringExtra("title");
        String scontent = gitent.getStringExtra("content");
        String slink = gitent.getStringExtra("link");

        //approval.setText(sapprove);
        datetime.setText(sdatetime);
        title.setText(stitle);
        content.setText(scontent);
        link.setText(slink);

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
