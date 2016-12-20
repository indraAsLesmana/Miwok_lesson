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
public class PharasesFragment extends Fragment {

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

    public PharasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_listview, container, false);

        listView = (ListView) rootView.findViewById(R.id.list_data);

        /**
         * mAudioManager is handle AudioRequest to SystemService
         * */
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
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

        final WordAdapter adapter = new WordAdapter(getActivity(), theData, R.color.category_phrases);

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
