package com.example.partynership;

import androidx.annotation.Nullable;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SavePostRequest extends StringRequest {
    final static private String URL = "http://112.175.185.136:8080/Partynership/Partynership.jsp";
    private Map<String,String> parameters;
    public SavePostRequest(int method, String url, Response.Listener<String> listener, @Nullable Response.ErrorListener errorListener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }

}
