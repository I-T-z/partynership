package com.example.partynership;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

<<<<<<< HEAD
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
=======
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

>>>>>>> origin/hyen
import java.util.ArrayList;
import java.util.List;

// 자유게시판 구현
public class Fragment1 extends Fragment {

    private ListView listView;
    private List<com.example.partynership.FreeListItem> fList;
    private FreeListAdapter adapter;
<<<<<<< HEAD
    private List<FreeListItem> fList;
    Button wtnbtn;
=======
    private Button wtnbtn;
>>>>>>> origin/hyen

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        listView = view.findViewById(R.id.free_boardlist);
        wtnbtn = view.findViewById(R.id.writing_btn);

<<<<<<< HEAD
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
=======
        //TODO: 커스텀 리스트 뷰
        // ListView참조 붙일 xml 명시
        listView = view.findViewById(R.id.free_boardlist);
        fList = generateItemsList();
        //어댑터 생성
        adapter = new com.example.partynership.FreeListAdapter(getActivity(), fList);

        // 어댑터 설정
        listView.setAdapter(adapter);

        // 데이터 변경 알림
        adapter.notifyDataSetChanged();
        //얘는 문제가 없음
        String boardCode = "자유";

        // 서버에서 데이터 받아와 처리
        //fetchFreeBoardData(boardCode);

        // 게시물 작성 버튼 클릭 리스너
        wtnbtn.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), NewPostFree.class);
            intent.putExtra("boardname", "자유게시판");
            startActivity(intent);
>>>>>>> origin/hyen
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

     

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent(getActivity(), Post.class);
                    intent.putExtra("forward","자유");
                    intent.putExtra("content","그냥 이대로 하면 되는건가요? 잘 모르겠어요ㅜㅜ");
                    intent.putExtra("title","재화 어떻게 모으나여?");
                    intent.putExtra("datetime","2024-10-21 00:01:23");
                    startActivity(intent);
                }

            }
        });
        return view;
    }
<<<<<<< HEAD

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
=======

    private List<FreeListItem> generateItemsList() {
        List<FreeListItem> fList = new ArrayList<>();
        fList.add(new FreeListItem("[자유]", "재화 어떻게 모으나여?", "뭉가", "2024-01-23 00:01:23"));
        fList.add(new FreeListItem("[자유]", "던전 ㅊㅊ좀여 ", "혠이", "2024-01-23 00:01:23"));
        fList.add(new FreeListItem("[공략]", "비틱좀할게", "옌이", "2024-01-23 00:01:23"));
        fList.add(new FreeListItem("[자유]", "종강 언제하냐", "쑤", "2024-01-23 00:01:23"));

        return fList;

        //    private void fetchFreeBoardData(String boardCode) {
//        FreeBoardListRequest fbRequest = new FreeBoardListRequest(boardCode, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                handleResponse(response);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                // 에러 처리
//                error.printStackTrace(); // 오류 로그 출력
//            }
//        });
//
//        RequestQueue queue = Volley.newRequestQueue(getContext());
//        queue.add(fbRequest);
//    }
//
//    private void handleResponse(String response) {
//        try {
//            JSONObject jsonResponse = new JSONObject(response);
//            boolean success = jsonResponse.getBoolean("success");
//
//            if (success) {
//                JSONArray contentArray = jsonResponse.getJSONArray("contentList");
//                List<FreeListItem> fList = new ArrayList<>();
//
//                for (int i = 0; i < contentArray.length(); i++) {
//                    JSONObject item = contentArray.getJSONObject(i);
//                    String boardCodeFromDB = item.getString("boardCode");
//
//                    if (boardCodeFromDB.equals("자유")) {
//                        String forward = item.getString("forward");
//                        String subTitle = item.getString("title");
//                        String memName = item.getString("member");
//                        String freeDateTime = item.getString("freeDateTime");
//
//                        fList.add(new FreeListItem(forward, subTitle, memName, freeDateTime));
//                    }
//                }
//
//                // 리스트 뷰에 데이터 바인딩
//                adapter = new FreeListAdapter(getContext(), fList);
//                listView.setAdapter(adapter);
//            } else {
//                // 실패 처리
//                // 필요한 경우 실패 메시지 또는 UI 업데이트
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    }
}
>>>>>>> origin/hyen
