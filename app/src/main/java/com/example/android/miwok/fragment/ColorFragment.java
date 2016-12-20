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
public class ColorFragment extends Fragment {
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

    public ColorFragment() {
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

        theData.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        theData.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        theData.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        theData.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        theData.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        theData.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        theData.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        theData.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        final WordAdapter adapter = new WordAdapter(getActivity(), theData, R.color.category_colors);

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
