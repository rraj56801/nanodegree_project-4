package com.example.android.mymusicapp;

/**
 * Created by RajBaba on 08-08-2017.
 */
public class Song {
    private String mSong;
    private String mSinger;

    // Default constructor
    public Song(String song, String singer) {
        mSong = song;
        mSinger = singer;
    }

    /**
     * This method gets song name
     *
     * @return song
     */
    public String getSong() {
        return mSong;
    }

    /**
     * This method gets singer name
     *
     * @return singer
     */
    public String getSinger() {
        return mSinger;
    }
}
