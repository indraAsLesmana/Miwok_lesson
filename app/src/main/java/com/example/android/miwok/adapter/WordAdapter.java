package com.example.android.miwok.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.miwok.R;

import java.util.ArrayList;

import com.example.android.miwok.helper.Helper;
import com.example.android.miwok.model.Word;

/**
 * Created by indraaguslesmana on 12/13/16.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mActivityCheck;

    public WordAdapter(Context context, ArrayList<Word> words, int activityCaller) {
        super(context, 0, words);
        mActivityCheck = activityCaller;
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

        if (mActivityCheck == Helper.ACTIVITY_PHARASES){
            imageView.setVisibility(View.GONE);
        }

        switch (mActivityCheck){
            case Helper.ACTIVITY_NUMBERS:
                imageView.setImageResource(R.drawable.ic_format_list_numbered_black_36dp);
                break;
            case Helper.ACTIVITY_FAMILY_MEMBERS:
                imageView.setImageResource(R.drawable.ic_account_balance_black_36dp);
                break;
            case Helper.ACTIVITY_COLORS:
                imageView.setImageResource(android.R.drawable.btn_star_big_off);
        }

        defaultWord.setText(wordData.getmDefaultWord());
        miwokWord.setText(wordData.getmMiwokWord());

        return listItemView;
    }
}
