package com.example.partynership;

public class JoinListItem {
    private String name;
    private String score;
    private String info;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    JoinListItem(String name, String score, String info) {
        this.name = name;
        this.score = score;
        this.info = info;

    }
}
