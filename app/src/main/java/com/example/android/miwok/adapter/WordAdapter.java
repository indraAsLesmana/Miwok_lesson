package com.example.android.miwok.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.miwok.R;

import java.util.ArrayList;

import com.example.android.miwok.helper.ActivityConstants;
import com.example.android.miwok.model.Word;

/**
 * Created by indraaguslesmana on 12/13/16.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int activityCheck;

    public WordAdapter(Context context, ArrayList<Word> words, int activityCaller) {
        super(context, 0, words);
        activityCheck = activityCaller;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            if(activityCheck != ActivityConstants.ACTIVITY_4)
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
            else {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.list_item_withoutimage, parent, false);
            }
        }

        Word wordData = getItem(position);

        TextView defaultWord = (TextView) listItemView.findViewById(R.id.english_library);
        TextView miwokWord = (TextView) listItemView.findViewById(R.id.miwok_library);

        defaultWord.setText(wordData.getmDefaultWord());
        miwokWord.setText(wordData.getmMiwokWord());

        return listItemView;
    }
}
