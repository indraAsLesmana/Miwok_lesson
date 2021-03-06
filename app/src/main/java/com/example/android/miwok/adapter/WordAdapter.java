package com.example.android.miwok.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.miwok.R;

import java.util.ArrayList;
import com.example.android.miwok.model.Word;

/**
 * Created by indraaguslesmana on 12/13/16.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorBackground;
    private Word wordData;
    private TextView miwokWord;

    private TextView defaultWord;
    private ImageView imageView;
    private LinearLayout mBackground;
    private RelativeLayout playButton_layout;
    private boolean mIsMediaPlayed;

    public WordAdapter(Context context, ArrayList<Word> words, int color) {
        super(context, 0, words);
        mColorBackground = color;
        /**
         * another way to check ho is caller
         * */
        /*if(context instanceof PhrasesActivity){
            mActivityCheck = Helper.ACTIVITY_PHARASES;
        }*/
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        wordData = getItem(position);

        defaultWord = (TextView) listItemView.findViewById(R.id.english_library);
        miwokWord = (TextView) listItemView.findViewById(R.id.miwok_library);
        imageView = (ImageView) listItemView.findViewById(R.id.image_list);
        mBackground = (LinearLayout) listItemView.findViewById(R.id.background_list);
        final ImageView playButton = (ImageView) listItemView.findViewById(R.id.play_button);
        playButton_layout = (RelativeLayout) listItemView.findViewById(R.id.play_button_layout);

        if (!wordData.hasImage()) {
            imageView.setVisibility(View.GONE);
            playButton_layout.setVisibility(View.GONE);
        } else {
            imageView.setVisibility(View.VISIBLE);
            playButton_layout.setVisibility(View.VISIBLE);
            imageView.setImageResource(wordData.getmImageResourceId());
        }

        /**
         * @param mColorBackground is pasing from all activity as parameter on this word adapter;
         * @param colorResult is must be converting to get color work
         * */
        int colorResult = ContextCompat.getColor(getContext(), mColorBackground);
        mBackground.setBackgroundColor(colorResult);

        defaultWord.setText(wordData.getmDefaultWord());
        miwokWord.setText(wordData.getmMiwokWord());

        if(wordData.ismIsPlayed()){
            playButton.setImageResource(android.R.drawable.ic_media_pause);
        }else {
            playButton.setImageResource(android.R.drawable.ic_media_play);
        }

        return listItemView;
    }

}
