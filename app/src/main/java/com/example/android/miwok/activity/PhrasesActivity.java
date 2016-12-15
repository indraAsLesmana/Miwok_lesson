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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.miwok.R;
import com.example.android.miwok.adapter.WordAdapter;
import com.example.android.miwok.model.Word;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = (ListView) findViewById(R.id.list_data);

        ArrayList<Word> theData = new ArrayList<>();

        theData.add(new Word("Where are you going?", "minto wuksus"));
        theData.add(new Word("What is your name?", "tinnә oyaase'nә"));
        theData.add(new Word("My name is...", "oyaaset..."));
        theData.add(new Word("How are you feeling?", " michәksәs?"));
        theData.add(new Word("I’m feeling good.", "kuchi achit"));
        theData.add(new Word("Are you coming?", "әәnәs'aa?"));
        theData.add(new Word("Yes, I’m coming.", "hәә’ әәnәm"));
        theData.add(new Word("I’m coming.", "әәnәm"));
        theData.add(new Word("Let’s go.", "yoowutis"));
        theData.add(new Word("Come here.", "әnni'nem"));

        WordAdapter adapter = new WordAdapter(this, theData, R.color.category_phrases);

        listView.setAdapter(adapter);
    }
}
