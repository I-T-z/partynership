package com.example.partynership;

public class PartyListItem {
    private String subText;
    private String numText;
    private int commuProfile;

    public String getSubText() {
        return subText;
    }

    public void setSubText(String _subText) {
        subText = _subText;
    }

    public String getNumText() {
        return numText;
    }

    public void setNumText(String _numText) {
        numText = _numText;
    }

    public int getCommuProfile() {
        return commuProfile;
    }

    public void setCommuProfile(int _commuProfile) {
        commuProfile = _commuProfile;
    }

    PartyListItem(String _subText, String _numText, int _commuProfile) {
        subText = _subText;
        numText = _numText;
        commuProfile = _commuProfile;
    }

}
