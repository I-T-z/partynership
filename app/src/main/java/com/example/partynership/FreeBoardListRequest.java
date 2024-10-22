package com.example.partynership;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

public class FreeBoardListRequest extends StringRequest {

    final static private String URL = "http://52.64.230.88:8080/partynership/free_board_list.jsp";
    private Map<String, String> parameters;

    public FreeBoardListRequest(String boardCode, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Method.POST, URL, listener, errorListener);
        parameters = new HashMap<>();
        parameters.put("boardCode", boardCode); // 게시판 코드만 전달
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}
