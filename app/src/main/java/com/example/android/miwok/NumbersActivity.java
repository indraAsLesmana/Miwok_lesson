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
package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.ArrayList;

import adapter.WordAdapter;
import model.Word;

public class NumbersActivity extends AppCompatActivity {

    ListView listView;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        listView = (ListView) findViewById(R.id.listNumber);

        ArrayList<Word> theData = new ArrayList<>();

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
        theData.add(new Word("one", "lutti"));
        theData.add(new Word("two", "otiko"));
        theData.add(new Word("three", "tolookosu"));
        theData.add(new Word("four", "oyyisa"));
        theData.add(new Word("five", "massoka"));
        theData.add(new Word("six", "temmoka"));
        theData.add(new Word("seven", "kenekaku"));
        theData.add(new Word("eight", "kawinta"));
        theData.add(new Word("nine", "wo'e"));
        theData.add(new Word("ten", "na'aacha"));

//        ArrayAdapter<Word> adapter = new ArrayAdapter<Word>(this, R.layout.list_item, theData);
        WordAdapter adapter = new WordAdapter(this, theData);

        listView.setAdapter(adapter);
    }

}
