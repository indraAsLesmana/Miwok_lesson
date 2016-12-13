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
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        String[] theData = {"one", "two", "three", "four"};
        ArrayList<String> temp = new ArrayList<>();

        for (String data : theData) {
            temp.add(data);
        }

        temp.add("six");
        temp.add("seven");

        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        /*for (int i = 0; i < temp.size(); i++) {
            TextView text = new TextView(this);
            text.setText(temp.get(0));
            rootView.addView(text);
        }*/

        /*Map<String, String> n = new HashMap<String, String>();
        for (int i = 0; i < temp.size(); i++) {
            n.put("number" + i, temp.get(i));
        }*/

        int index = 0;
        while (index != 4){
            Log.v(getPackageName(), "Number: "+ temp.get(index));
            index++;
        }

        for (int i = 0; i < temp.size(); i++) {
            TextView text = new TextView(this);
            text.setText(temp.get(i));
            rootView.addView(text);
        }

    }
}
