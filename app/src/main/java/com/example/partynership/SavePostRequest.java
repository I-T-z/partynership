package com.example.partynership;

import androidx.annotation.Nullable;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SavePostRequest extends StringRequest {
    final static private String URL = "http://112.175.185.136:8080/Partynership/Partynership.jsp";
    private Map<String,String> parameters;
    public SavePostRequest(String datetime,  String title, String content, String link, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();

        // 파라미터에 날짜, 제목, 내용, 링크 추가
        parameters.put("datetime", datetime);   // 날짜+시간
        parameters.put("title", title);         // 제목
        parameters.put("content", content);     // 내용
        parameters.put("link", link);           // 링크
    }
    @Override
    public Map<String, String> getParams() {
        return parameters;
    }

}
