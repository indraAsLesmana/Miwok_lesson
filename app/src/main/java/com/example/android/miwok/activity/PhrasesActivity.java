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
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.miwok.R;
import com.example.android.miwok.adapter.WordAdapter;
import com.example.android.miwok.model.Word;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private ListView listView;
    private MediaPlayer mediaPlayer;
    private static final int NO_AUDIO = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = (ListView) findViewById(R.id.list_data);

        final ArrayList<Word> theData = new ArrayList<>();

        theData.add(new Word("Where are you going?", "minto wuksus", 0, R.raw.phrase_where_are_you_going));
        theData.add(new Word("What is your name?", "tinnә oyaase'nә", 0, R.raw.phrase_what_is_your_name));
        theData.add(new Word("My name is...", "oyaaset...", 0, R.raw.phrase_my_name_is));
        theData.add(new Word("How are you feeling?", " michәksәs?", 0, R.raw.phrase_how_are_you_feeling));
        theData.add(new Word("I’m feeling good.", "kuchi achit", 0, R.raw.phrase_im_feeling_good));
        theData.add(new Word("Are you coming?", "әәnәs'aa?", 0, R.raw.phrase_are_you_coming));
        theData.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", 0, R.raw.phrase_yes_im_coming));
        theData.add(new Word("I’m coming.", "әәnәm", 0, R.raw.phrase_im_coming));
        theData.add(new Word("Let’s go.", "yoowutis", 0, R.raw.phrase_lets_go));
        theData.add(new Word("Come here.", "әnni'nem", 0, R.raw.phrase_come_here));

        WordAdapter adapter = new WordAdapter(this, theData, R.color.category_phrases);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, theData.get(position).getmAudioFile());
                if (theData.get(position).getmAudioFile() == NO_AUDIO) {
                    Toast.makeText(PhrasesActivity.this, "There's no Audio file", Toast.LENGTH_SHORT).show();
                } else if (!mediaPlayer.isPlaying()) { //isPlaying() is MediaPlayer method for check is audio played ?
                    mediaPlayer.start();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mediaPlayer.stop();
                        }
                    }, mediaPlayer.getDuration());
                }
            }
        });
    }
}
