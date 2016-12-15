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

public class ColorsActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = (ListView) findViewById(R.id.list_data);
        ArrayList<Word> theData = new ArrayList<>();

        theData.add(new Word("red", "weṭeṭṭi", R.drawable.color_red));
        theData.add(new Word("green", "chokokki", R.drawable.color_green));
        theData.add(new Word("brown", "ṭakaakki", R.drawable.color_brown));
        theData.add(new Word("gray", "ṭopoppi", R.drawable.color_gray));
        theData.add(new Word("black", "kululli", R.drawable.color_black));
        theData.add(new Word("white", "kelelli", R.drawable.color_white));
        theData.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow));
        theData.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow));

        WordAdapter adapter = new WordAdapter(this, theData, R.color.category_colors);

        listView.setAdapter(adapter);

    }
}
