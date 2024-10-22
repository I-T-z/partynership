package com.example.partynership;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

//탭으로 구현된 게시판 fragment들 총 관리

public class MBoardActivity extends AppCompatActivity {
    Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.TapLayout);
        viewPager = findViewById(R.id.ViewPager2);

        VPAdapter vpAdapter = new VPAdapter(this);
        vpAdapter.addFragment(new Fragment1(), "자유게시판");
        vpAdapter.addFragment(new Fragment2(), "파티게시판");
        vpAdapter.addFragment(new Fragment3(), "멘토/멘티게시판");
        viewPager.setAdapter(vpAdapter);

        // Intent로 전달된 fragmentKey 값 받아서 ViewPager의 현재 페이지 설정
        Intent intent = getIntent();
        int fragmentKey = intent.getIntExtra("fragmentKey", 0);  // 기본값은 0 (자유게시판)


        // TabLayout과 ViewPager2 연결
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            tab.setText(vpAdapter.getPageTitle(position));
        }).attach();
        if (fragmentKey >= 0 && fragmentKey < vpAdapter.getItemCount()) {
            Log.d("mytest", "onCreate: " + viewPager.getCurrentItem());
            viewPager.setCurrentItem(fragmentKey);  // 해당 fragmentKey 값으로 페이지 이동
            Log.d("mytest", "setCurrentItem: " + viewPager.getCurrentItem());
        } else {
            Log.d("mytest", "Invalid fragmentKey: " + fragmentKey + ", setting to default (0)");
            viewPager.setCurrentItem(0);  // 기본값으로 설정
            }
        }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.main_menu, menu);  // main_menu.xml 파일에서 메뉴 항목 추가
            return true;
        }

        //툴바에 표시된 액션 또는 오버플로우 메뉴가 선택되면 액티비티의 onOptionsItemSelected() 메소드가 호출
        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            if (item.getItemId() == R.id.home) {
                Intent newActivityHome = new Intent(MBoardActivity.this, MainActivity.class);
                startActivity(newActivityHome);
                return true;
            } else if (item.getItemId() == R.id.profile) {
                try {
                    Intent newActivityProfile = new Intent(MBoardActivity.this, MyPageBoard.class);
                    startActivity(newActivityProfile);
                } catch (Exception e) {
                    Log.e("Error", "Failed to start MyPageBoard activity", e);
                    Log.d("test", "마이페이지 버튼이 눌림");
                }
                return true;
            } else {
                return super.onOptionsItemSelected(item);
            }


        }
    }