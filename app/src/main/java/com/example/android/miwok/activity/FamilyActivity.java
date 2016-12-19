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

public class FamilyActivity extends AppCompatActivity {

    private ListView listView;
    private MediaPlayer mMediaPlayer;
    private static final int NO_AUDIO = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = (ListView) findViewById(R.id.list_data);
        /** library ---
         * 1father, әpә
         * 2 mother,әṭa
         * 3 son,angsi
         * 4 daughter, tune
         * 5 older brother, taachi
         * 6 younger brother, chalitti
         * 7 older sister, teṭe
         * 8 younger sister, kolliti
         * 9 grandmother, ama
         * 10 grandfather, paapa
         * */

        /**
         * this the order way, with split up data. if data source from xml R.array
         *
         * */

        int[] drawableData = {
                R.drawable.family_father,
                R.drawable.family_mother,
                R.drawable.family_son,
                R.drawable.family_daughter,
                R.drawable.family_older_brother,
                R.drawable.family_younger_brother,
                R.drawable.family_older_sister,
                R.drawable.family_younger_sister,
                R.drawable.family_grandmother,
                R.drawable.family_grandfather
        };
        int[] soundData = {
                R.raw.family_father,
                R.raw.family_mother,
                R.raw.family_son,
                R.raw.family_daughter,
                R.raw.family_older_brother,
                R.raw.family_younger_brother,
                R.raw.family_older_sister,
                R.raw.family_younger_sister,
                R.raw.family_grandmother,
                R.raw.family_grandfather
        };

        final ArrayList<Word> wordLibrary = new ArrayList<>();
        String [] familymemberData = getResources().getStringArray(R.array.family_member);

        for (int i = 0; i < familymemberData.length; i++) {
            String dataSplit = familymemberData[i];
            String [] splitResult = dataSplit.split("\\|", 2);
            wordLibrary.add(new Word(splitResult[0], splitResult[1], drawableData[i], soundData[i]));
        }

        final WordAdapter adapter = new WordAdapter(this, wordLibrary, R.color.category_family);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                final Word word = wordLibrary.get(position);
                mMediaPlayer = Helper.clearMediaplayer(mMediaPlayer);
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getmAudioFile());
                if (word.getmAudioFile() == NO_AUDIO) {
                    Toast.makeText(FamilyActivity.this, "There's no Audio file",
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
