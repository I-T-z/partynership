package com.example.partynership;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    private GridView select_grid;
    private List<GridItem> gList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 레이아웃 설정

        //GridView 초기화
        select_grid = findViewById(R.id.select_grid);
        //데이터생성
        gList = generateItemList();

        //어댑터 생성
        GridAdapter gAdapter = new GridAdapter(this, gList);
        select_grid.setAdapter(gAdapter);

        select_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GridItem selectedItem = gList.get(position);
                // TODO: 선택된 아이템에 따라 다른 액티비티로 이동
                Log.d("test", "onItemClick: 왜 안넘어감?");
                Intent intent = new Intent(MainActivity.this, FreeBoardActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<GridItem> generateItemList() {
        List<GridItem> gList = new ArrayList<>();
        gList.add(new GridItem(R.drawable.add_circle_, "리그오브레전드"));
        gList.add(new GridItem(R.drawable.add_circle_, "발로란트"));
        gList.add(new GridItem(R.drawable.add_circle_, "오버워치"));
        gList.add(new GridItem(R.drawable.add_circle_, "배틀그라운드"));
        gList.add(new GridItem(R.drawable.add_circle_, "테일즈런너"));
        gList.add(new GridItem(R.drawable.add_circle_, "피파4"));
        return gList;


    }
}