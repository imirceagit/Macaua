package com.example.mirceaionita.macaua.entity;

import android.graphics.Bitmap;

/**
 * Created by mircea.ionita on 10/17/2016.
 */
public class Card {

    private int id;
    private Bitmap bmp;

    public Card(int newId){
        id = newId;
    }

    public int getId() {
        return id;
    }

    public Bitmap getBitmap() {
        return bmp;
    }

    public void setBitmap(Bitmap bmp) {
        this.bmp = bmp;
    }
}
