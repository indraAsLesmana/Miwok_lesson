package com.example.android.miwok.model;


/**
 * Created by indraaguslesmana on 12/13/16.
 */

public class Word {
    private String mDefaultWord;
    private String mMiwokWord;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = 0;
    private int mAudioFile;
    private boolean mIsPlayed;
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

    public Word(String mDefaultWord, String mMiwokWord, int mImageResourceId, int audioFile,
                boolean isPlayed) {
        this.mDefaultWord = mDefaultWord;
        this.mMiwokWord = mMiwokWord;
        this.mImageResourceId = mImageResourceId;
        this.mAudioFile = audioFile;
        mIsPlayed = isPlayed;
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

    public boolean ismIsPlayed() {
        return mIsPlayed;
    }

    public void setmIsPlayed(boolean mIsPlayed) {
        this.mIsPlayed = mIsPlayed;
    }

    /**
     * retrun the string refresentation of {@link Word} Object
     * this example if you want look the all value of this object with LOG.V for example
     * this code generate by cliking, control + enter --> toString()
     * */
    @Override
    public String toString() {
        return "Word{" +
                "mDefaultWord='" + mDefaultWord + '\'' +
                ", mMiwokWord='" + mMiwokWord + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioFile=" + mAudioFile +
                '}';
    }
}
