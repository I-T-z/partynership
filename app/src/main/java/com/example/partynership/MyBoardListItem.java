package com.example.partynership;

import android.util.Log;

public class MyBoardListItem {

    private String forward;
    private String title;
    private String memName;
    private String dateTime;
    @Override
    public String toString() {
        return "제목: " + forward + ", 게시물제목: " + title + ", 작성자: " + memName;
    }

    public String getForward() {
        return forward;
    }

    public void setForward(String forward) {
        this.forward = forward;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    //이 생성자를 통해서 값을 넘겨받고 전역변수에 저장한다.
    MyBoardListItem(String _forward, String _title, String _memName, String _dateTime){
        forward = _forward;
        title = _title;
        memName =_memName;
        dateTime =_dateTime;
        Log.d("mytest","리스트에 데이터 삽입");

    }

}
