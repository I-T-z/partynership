package com.example.partynership;

import android.media.Image;
import android.widget.LinearLayout;

public class GridItem {
    private String gameName;
    private int imageResId; //리사이클

    public GridItem(int _imageResId, String _gameName) {
        imageResId = _imageResId;
        gameName = _gameName;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String _gameName) {
        gameName = _gameName;
    }

    public int getImageResId() {
        return imageResId;
    }

}
