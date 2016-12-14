package com.example.android.miwok.model;

/**
 * Created by indraaguslesmana on 12/13/16.
 */

public class Word {
    private String mDefaultWord;
    private String mMiwokWord;
    private int mImageResourceId;

    public Word(String mDefaultWord, String mMiwokWord, int mImageResourceId) {
        this.mDefaultWord = mDefaultWord;
        this.mMiwokWord = mMiwokWord;
        this.mImageResourceId = mImageResourceId;
    }

    public Word(String mDefaultWord, String mMiwokWord) {
        this.mDefaultWord = mDefaultWord;
        this.mMiwokWord = mMiwokWord;
    }

    public String getmDefaultWord() {
        return mDefaultWord;
    }

    public String getmMiwokWord() {
        return mMiwokWord;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }
}
