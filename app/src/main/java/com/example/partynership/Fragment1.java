package com.example.partynership;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//자유게시판 구현

public class Fragment1 extends Fragment {

    private ListView listView;
    private FreeListAdapter adapter;
    private List<FreeListItem> fList;
    Button wtnbtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        listView = view.findViewById(R.id.free_boardlist);
        wtnbtn = view.findViewById(R.id.writing_btn);

        // 리스트 초기화 및 어댑터 설정
        fList = new ArrayList<>();
        adapter = new FreeListAdapter(getContext(), fList);
        listView.setAdapter(adapter);

        // 게시글 데이터 가져오기
        new GetPostsTask().execute("http://52.64.230.88:8080/partynership/free_board.jsp");

        //게시물 작성 버튼 누르기
        wtnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //어느 게시판에서 넘어갔는지에 따라 나타나는 작성창 형식 다름
                Intent intent = new Intent(getActivity(), NewPostFree.class);
                intent.putExtra("boardname","자유게시판");
                startActivity(intent);
            }
        });

        return view;
    }

    private class GetPostsTask extends AsyncTask<String, Void, List<FreeListItem>> {
        @Override
        protected List<FreeListItem> doInBackground(String... urls) {
            List<FreeListItem> items = new ArrayList<>();
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder jsonString = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonString.append(line);
                }
                reader.close();

                // JSON 파싱
                JSONArray jsonArray = new JSONArray(jsonString.toString());
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String forward = jsonObject.getString("forward");
                    String title = jsonObject.getString("title");
                    String memberName = jsonObject.getString("memberName");
                    String createdAt = jsonObject.getString("freeDate");
                    // FreeListItem 생성 및 추가
                    items.add(new FreeListItem(forward, title, memberName, createdAt));
                }
            } catch (Exception e) {
                Log.e("GetPostsTask", "Error: " + e.getMessage());
            }
            return items;
        }

        @Override
        protected void onPostExecute(List<FreeListItem> items) {
            fList.clear();
            fList.addAll(items);
            adapter.notifyDataSetChanged(); // 어댑터에 데이터 변경 알림
        }
    }
}