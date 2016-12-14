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

import java.util.ArrayList;

import com.example.android.miwok.R;
import com.example.android.miwok.adapter.WordAdapter;
import com.example.android.miwok.model.Word;

public class FamilyActivity extends AppCompatActivity {

    private ListView listView;

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

        ArrayList<Word> wordLibrary = new ArrayList<>();
        String [] familymemberData = getResources().getStringArray(R.array.family_member);

        for (int i = 0; i < familymemberData.length; i++) {
            String dataSplit = familymemberData[i];
            String [] splitResult = dataSplit.split("\\|", 2);
            wordLibrary.add(new Word(splitResult[0], splitResult[1], drawableData[i]));
        }

        WordAdapter adapter = new WordAdapter(this, wordLibrary);
        listView.setAdapter(adapter);

    }
}
