package com.example.partynership;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MyFragment1 extends Fragment {

    private ListView listView;
    private MyBoardListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my1, container, false);
        listView = view.findViewById(R.id.my_list);

        // 데이터를 서버에서 받아오기
        new FetchDataTask().execute("http://52.64.230.88:8080/partynership/get_my_post.jsp");

        return view;
    }

    private class FetchDataTask extends AsyncTask<String, Void, List<MyBoardListItem>> {

        @Override
        protected List<MyBoardListItem> doInBackground(String... urls) {
            List<MyBoardListItem> mList = new ArrayList<>();
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                StringBuilder jsonBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonBuilder.append(line);
                }
                reader.close();

                // JSON 파싱
                JSONArray jsonArray = new JSONArray(jsonBuilder.toString());
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    String forward = obj.getString("forward");
                    String title = obj.getString("title");
                    String memName = obj.getString("memberName");
                    String dateTime = obj.getString("dateTime");

                    mList.add(new MyBoardListItem(forward, title, memName, dateTime));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return mList;
        }

        @Override
        protected void onPostExecute(List<MyBoardListItem> result) {
            // 어댑터 설정
            adapter = new MyBoardListAdapter(getContext(), result);
            listView.setAdapter(adapter);
        }
    }
}