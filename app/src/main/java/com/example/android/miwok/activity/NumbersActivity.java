/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok.activity;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.android.miwok.R;
import com.example.android.miwok.adapter.WordAdapter;
import com.example.android.miwok.helper.Helper;
import com.example.android.miwok.model.Word;

public class NumbersActivity extends AppCompatActivity {

    private ListView listView;
    private MediaPlayer mMediaPlayer;
    private static final int NO_AUDIO = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = (ListView) findViewById(R.id.list_data);

        final ArrayList<Word> theData = new ArrayList<>();

        /**
         1 one lutti
         2 two otiiko
         3 three tolookosu
         4 four oyyisa
         5 five massokka
         6 six temmokka
         7 seven kenekaku
         8 eight kawinta
         9 nine wo’e
         10 ten na’aacha
         * */
        theData.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        theData.add(new Word("two", "otiko", R.drawable.number_two, R.raw.number_two));
        theData.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        theData.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        theData.add(new Word("five", "massoka", R.drawable.number_five, R.raw.number_five));
        theData.add(new Word("six", "temmoka", R.drawable.number_six, R.raw.number_six));
        theData.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        theData.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        theData.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        theData.add(new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));

        final WordAdapter adapter = new WordAdapter(this, theData, R.color.category_numbers);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                final Word word = theData.get(position);
                mMediaPlayer = Helper.clearMediaplayer(mMediaPlayer);
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getmAudioFile());
                if (word.getmAudioFile() == NO_AUDIO) {
                    Toast.makeText(NumbersActivity.this, "There's no Audio file",
                            Toast.LENGTH_SHORT).show();
                }else {
                    /**
                     * "word.setIsPlayed" is helper play boolean, to change view from PLAY to PAUSE
                     * */
                    mMediaPlayer.start();
                    word.setmIsPlayed(true);
                    adapter.notifyDataSetChanged();

                    mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mMediaPlayer = Helper.clearMediaplayer(mMediaPlayer);// is for release alocate memory by mediaVariabel
                            word.setmIsPlayed(false);
                            adapter.notifyDataSetChanged();
                        }
                    });
                }
                Log.v(getPackageName(), "data: " + word); // is will log add data from object word
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMediaPlayer = Helper.clearMediaplayer(mMediaPlayer);
    }
}
