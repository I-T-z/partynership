package com.example.partynership;

import android.util.Log;

public class FreeListItem {

    private String forward;
    private String subTitle;
    private String memName;
    private String freeDateTime;


    public String getForward() {
        return forward;
    }

    public void setForward(String forward) {
        this.forward = forward;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getfreeDateTime() {
        return freeDateTime;
    }

    public void setfreeDateTime(String freeDate) {
        this.freeDateTime = freeDate;
    }

    //이 생성자를 통해서 값을 넘겨받고 전역변수에 저장한다.
    FreeListItem(String _forward, String _subTitle, String _memName, String _freeDateTime){
        forward = _forward;
        subTitle = _subTitle;
        memName =_memName;
        freeDateTime =_freeDateTime;
        Log.d("mytest","리스트에 데이터 삽입");
    }

}
