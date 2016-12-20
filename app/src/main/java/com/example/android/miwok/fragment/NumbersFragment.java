package com.example.android.miwok.fragment;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.miwok.R;
import com.example.android.miwok.adapter.WordAdapter;
import com.example.android.miwok.helper.Helper;
import com.example.android.miwok.model.Word;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {

    private ListView listView;
    private MediaPlayer mMediaPlayer;
    private static final int NO_AUDIO = 0;
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // Pause playback
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Resume playback
                        mMediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        mMediaPlayer = Helper.clearMediaplayer(mMediaPlayer);
                    }
                }
            };

    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_listview, container, false);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
        listView = (ListView) rootView.findViewById(R.id.list_data);

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

        final WordAdapter adapter = new WordAdapter(getActivity(), theData, R.color.category_numbers);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                final Word word = theData.get(position);
                mMediaPlayer = Helper.clearMediaplayer(mMediaPlayer);

                // Request audio focus for playback
                int result = mAudioManager.requestAudioFocus(onAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,              // Use the music stream.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);// Request permanent focus.

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback.
                    mMediaPlayer = MediaPlayer.create(getActivity(), word.getmAudioFile());
                    if (word.getmAudioFile() == NO_AUDIO) {
                        Toast.makeText(getActivity(), "There's no Audio file",
                                Toast.LENGTH_SHORT).show();
                    }else {
                        /**
                         * "word.setIsPlayed" is helper play boolean, to change button view from PLAY to PAUSE
                         * */
                        mMediaPlayer.start();
                        word.setmIsPlayed(true);
                        adapter.notifyDataSetChanged();

                        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                releaseAllAudio();// is for release alocate memory by mediaVariabel
                                word.setmIsPlayed(false);
                                adapter.notifyDataSetChanged();
                            }
                        });
                    }
                }
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseAllAudio();
    }

    private void releaseAllAudio (){
        mMediaPlayer = Helper.clearMediaplayer(mMediaPlayer); //clean release mediaPlayer
        mAudioManager.abandonAudioFocus(onAudioFocusChangeListener); // remove request audio focus
    }
}
