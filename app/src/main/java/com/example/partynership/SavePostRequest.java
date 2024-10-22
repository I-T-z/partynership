package com.example.partynership;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SavePostRequest extends StringRequest {
    final static private String URL = "http://52.64.230.88:8080/partynership/new_post_free.jsp"; // JSP 서버 주소
    private Map<String,String> params;
    public SavePostRequest(String title, String content, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Request.Method.POST, URL, listener, errorListener);
        params = new HashMap<>();

        // 파라미터에 게시판 코드, 멤버 코드, 제목, 내용, 링크 추가
        params.put("b_code", "1");          // 게시판 코드 (임시지정)
        params.put("m_code", "1");          // 멤버 코드 (임시지정)
        params.put("title", title);         // 제목
        params.put("content", content);     // 내용
    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
