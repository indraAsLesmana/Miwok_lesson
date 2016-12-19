package com.example.android.miwok.helper;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Toast;

import com.example.android.miwok.R;
import com.example.android.miwok.model.Word;

import java.util.ArrayList;

/**
 * Created by indraaguslesmana on 12/13/16.
 */

public class Helper {
    /**
     * this for identify activty caller
     * */
    public static final int ACTIVITY_NUMBERS = 1001;
    public static final int ACTIVITY_FAMILY_MEMBERS = 1002;
    public static final int ACTIVITY_COLORS = 1003;
    public static final int ACTIVITY_PHARASES = 1004;


    /**
     * create Toast for reused dinamicly
     * */
    public static void showToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * create Log v for reused dynamicly
     * */
    public static void showLogV (String stringContext, String message){
        Log.v(stringContext, message);
    }
    /**
     * clear mediaPlayer memory
     * */
    public static MediaPlayer clearMediaplayer (MediaPlayer mediaPlayer){
        if (mediaPlayer != null){
            mediaPlayer.release();
        }
        return null;
    }

}

