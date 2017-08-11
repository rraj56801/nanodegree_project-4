package com.example.android.musicplayerproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class Play_Pause extends AppCompatActivity {
    private Button btn_fast_forward;
    private Button btn_search;
    private Button btn_previous;
    private Button btn_next;
    private Button btn_replay;
    private Button btn_mute;
    private Button btn_unmute;
    private Button btn_shuffle;
    private Button btn_pause;
    private Button btn_play;
    private Button btn_rewind;
    private MediaPlayer song_first;
    private double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();
    private int forwardTime = 5000;
    private int backwardTime = 5000;
    private SeekBar seekbar;
    private TextView tv_left_seek;
    private TextView tv_right_seek;
    private TextView tv_middle_seek;
    private TextView songTitle_textView;
    private String mSongTitle = "Untitle";
    public static int oneTimeOnly = 0;
    Button btn_home;
    Button btn_folder;
    Button btn_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play__pause);
        songTitle_textView = (TextView) findViewById(R.id.tv_song_title);
        btn_home = (Button) findViewById(R.id.btn_home);
        btn_folder = (Button) findViewById(R.id.btn_folder);
        btn_profile = (Button) findViewById(R.id.btn_profile);
        btn_fast_forward = (Button) findViewById(R.id.btn_forward);
        btn_search = (Button) findViewById(R.id.btn_search);
        btn_pause = (Button) findViewById(R.id.btn_pause_id);
        btn_play = (Button) findViewById(R.id.btn_play_id);
        btn_previous = (Button) findViewById(R.id.btn_previous);
        btn_next = (Button) findViewById(R.id.btn_next);
        btn_replay = (Button) findViewById(R.id.btn_replay);
        btn_mute = (Button) findViewById(R.id.btn_mute);
        btn_unmute = (Button) findViewById(R.id.btn_unmute);
        btn_shuffle = (Button) findViewById(R.id.btn_shuffle);
        btn_rewind = (Button) findViewById(R.id.btn_rewind_id);
        tv_left_seek = (TextView) findViewById(R.id.text_left_seek);
        tv_right_seek = (TextView) findViewById(R.id.text_right_seek);
        tv_middle_seek = (TextView) findViewById(R.id.text_middle_seek);
        song_first = MediaPlayer.create(Play_Pause.this, R.raw.dil_kya_kare);
        seekbar = (SeekBar) findViewById(R.id.seekBar);
        seekbar.setClickable(false);
        btn_pause.setEnabled(false);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Play_Pause.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btn_folder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Play_Pause.this, Folder.class);
                startActivity(intent);
            }
        });
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Play_Pause.this, Profile.class);
                startActivity(intent);
            }
        });
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Playing sound", Toast.LENGTH_SHORT).show();
                mSongTitle = "Dil Kya Kare";
                tv_left_seek.setVisibility(View.VISIBLE);
                tv_middle_seek.setVisibility(View.VISIBLE);
                tv_right_seek.setVisibility(View.VISIBLE);
                tv_middle_seek.setText(mSongTitle);
                songTitle_textView.setText(mSongTitle);
                song_first.start();
                finalTime = song_first.getDuration();
                startTime = song_first.getCurrentPosition();
                if (oneTimeOnly == 0) {
                    seekbar.setMax((int) finalTime);
                    oneTimeOnly = 1;
                }
                tv_right_seek.setText(String.format("%d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                        finalTime)))
                );
                tv_left_seek.setText(String.format("%d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                        startTime)))
                );
                seekbar.setProgress((int) startTime);
                myHandler.postDelayed(UpdateSongTime, 100);
                btn_pause.setEnabled(true);
                btn_play.setEnabled(false);
            }
        });
        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pausing sound", Toast.LENGTH_SHORT).show();
                song_first.pause();
                btn_pause.setEnabled(false);
                btn_play.setEnabled(true);
            }
        });
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Play_Pause.this, Folder.class);
                startActivity(intent);
            }
        });
        btn_fast_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int) startTime;
                if ((temp + forwardTime) <= finalTime) {
                    startTime = startTime + forwardTime;
                    song_first.seekTo((int) startTime);
                    Toast.makeText(getApplicationContext(), "You have Jumped forward 5 seconds", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Cannot jump forward 5 seconds", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int) startTime;
                if ((temp - backwardTime) > 0) {
                    startTime = startTime - backwardTime;
                    song_first.seekTo((int) startTime);
                    Toast.makeText(getApplicationContext(), "You have Jumped backward 5 seconds", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Cannot jump backward 5 seconds", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Previous Button : updating soon", Toast.LENGTH_SHORT).show();
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Next Button : updating soon", Toast.LENGTH_SHORT).show();
            }
        });
        btn_replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Replay Button : updating soon", Toast.LENGTH_SHORT).show();
            }
        });
        btn_mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song_first.setVolume(0, 0);
            }
        });
        btn_unmute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song_first.setVolume(1, 1);
            }
        });
        btn_shuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Shuffle Button : updating soon", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = song_first.getCurrentPosition();
            startTime = song_first.getCurrentPosition();
            tv_left_seek.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );
            seekbar.setProgress((int) startTime);
            myHandler.postDelayed(this, 100);
        }
    };

    /**
     * Menu Implementation Method
     *
     * @param menu
     * @return
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_menu, menu);
        return (true);
    }

    /**
     * MenuItem Implementation Method
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:
                Toast.makeText(Play_Pause.this, "Updating soon", Toast.LENGTH_LONG).show();
                return (true);
            case R.id.help:
                Toast.makeText(Play_Pause.this, "Updating soon", Toast.LENGTH_LONG).show();
                return (true);
            case R.id.settings:
                Toast.makeText(Play_Pause.this, "Updating soon", Toast.LENGTH_LONG).show();
                return (true);
            case R.id.expanded_menu:
                Toast.makeText(Play_Pause.this, "Updating soon", Toast.LENGTH_LONG).show();
                return (true);
            case R.id.exit:
               System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
}

