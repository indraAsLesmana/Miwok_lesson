package com.example.android.miwok.model;

import android.graphics.drawable.Drawable;

/**
 * Created by indraaguslesmana on 12/13/16.
 */

public class Word {
    private String mDefaultWord;
    private String mMiwokWord;
    private Drawable image;

    public Word(String mDefaultWord, String mMiwokWord, Drawable image) {
        this.mDefaultWord = mDefaultWord;
        this.mMiwokWord = mMiwokWord;
        this.image = image;
    }

    public String getmDefaultWord() {
        return mDefaultWord;
    }

    public String getmMiwokWord() {
        return mMiwokWord;
    }

    public Drawable getImage() {
        return image;
    }
}
