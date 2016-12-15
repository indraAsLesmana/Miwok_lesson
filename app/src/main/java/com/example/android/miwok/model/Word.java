package com.example.android.miwok.model;

/**
 * Created by indraaguslesmana on 12/13/16.
 */

public class Word {
    private String mDefaultWord;
    private String mMiwokWord;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mAudioFile;
    /**
     * this is overloading constructor add new imageResourceid
     * @param mImageResourceId is for imageResourceId from drawable content
     * @param audioFile is resource audio file
     * */
    public Word(String mDefaultWord, String mMiwokWord, int mImageResourceId, int audioFile) {
        this.mDefaultWord = mDefaultWord;
        this.mMiwokWord = mMiwokWord;
        this.mImageResourceId = mImageResourceId;
        this.mAudioFile = audioFile;
    }

    public Word(String mDefaultWord, String mMiwokWord, int mImageResourceId) {
        this.mDefaultWord = mDefaultWord;
        this.mMiwokWord = mMiwokWord;
        this.mImageResourceId = mImageResourceId;
    }

    /**
     * primary construktor
     * @param mDefaultWord is value for english word
     * @param mMiwokWord is value for miwok apps
     * */
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

    public boolean hasImage (){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getmAudioFile() {
        return mAudioFile;
    }
}
