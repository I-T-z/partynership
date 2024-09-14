package com.example.partynership;

import android.util.Log;

public class MyBoardListItem {

    private String forward;
    private String subTitle;
    private String memName;
    private String riple;

    public String getRiple() {
        return riple;
    }

    public void setRiple(String riple) {
        this.riple = riple;
    }

    private String freeDate;
    private String freeTime;
    private String likenum;

    public String getLikenum() {
        return likenum;
    }

    public void setLikenum(String likenum) {
        this.likenum = likenum;
    }

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

    public String getFreeDate() {
        return freeDate;
    }

    public void setFreeDate(String freeDate) {
        this.freeDate = freeDate;
    }

    public String getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(String freeTime) {
        this.freeTime = freeTime;
    }

    //이 생성자를 통해서 값을 넘겨받고 전역변수에 저장한다.
    MyBoardListItem(String _forward, String _subTitle, String _memName,String _riple, String _freeDate, String _freeTime,String _likenum){
        forward = _forward;
        subTitle = _subTitle;
        memName =_memName;
        riple = _riple;
        freeDate =_freeDate;
        freeTime =_freeTime;
        likenum = _likenum;
        Log.d("mytest","리스트에 데이터 삽입");
    }

}
