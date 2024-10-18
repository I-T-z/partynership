package com.example.partynership;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;


public class MyPageBoard extends AppCompatActivity {
    Toolbar toolbar;
    ImageButton backbtn,setbtn;
    private ListView myBoardlist;
    MyBoardListAdapter mAdapter;
    private List<MyBoardListItem> mList;

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private VPAdapter vpAdapter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        backbtn = findViewById(R.id.back_button);
        tabLayout = findViewById(R.id.TapLayout);
        setbtn = findViewById(R.id.setting_button);

        viewPager = findViewById(R.id.ViewPager2);

        vpAdapter = new VPAdapter(this);
        vpAdapter.addFragment(new MyFragment1(), "게시물");
        vpAdapter.addFragment(new MyFragment2(), "후기");
        viewPager.setAdapter(vpAdapter);

        // TabLayout과 ViewPager2 연결
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            tab.setText(vpAdapter.getPageTitle(position));
        }).attach();

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        setbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPageBoard.this, SettingActivity.class);
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




