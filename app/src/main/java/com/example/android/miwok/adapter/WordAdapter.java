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
import android.widget.TextView;

import com.example.android.miwok.R;

import java.util.ArrayList;
import com.example.android.miwok.helper.Helper;
import com.example.android.miwok.model.Word;

/**
 * Created by indraaguslesmana on 12/13/16.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorBackground;

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

        Word wordData = getItem(position);

        TextView defaultWord = (TextView) listItemView.findViewById(R.id.english_library);
        TextView miwokWord = (TextView) listItemView.findViewById(R.id.miwok_library);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_list);
        LinearLayout mBackground = (LinearLayout) listItemView.findViewById(R.id.background_list);


        if (!wordData.hasImage()) {
            imageView.setVisibility(View.GONE);
        } else {
            imageView.setVisibility(View.VISIBLE);
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

        return listItemView;
    }

}
