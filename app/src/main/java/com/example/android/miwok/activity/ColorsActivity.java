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
import com.example.android.miwok.helper.ActivityConstants;
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

        theData.add(new Word("red", "weṭeṭṭi"));
        theData.add(new Word("green", "chokokki"));
        theData.add(new Word("brown", "ṭakaakki"));
        theData.add(new Word("gray", "ṭopoppi"));
        theData.add(new Word("black", "kululli"));
        theData.add(new Word("white", "kelelli"));
        theData.add(new Word("dusty yellow", "ṭopiisә"));
        theData.add(new Word("mustard yellow", "chiwiiṭә"));

        WordAdapter adapter = new WordAdapter(this, theData, ActivityConstants.ACTIVITY_3);

        listView.setAdapter(adapter);

    }
}
