package com.example.android.mymusicapp;
/**
 * Created by RajBaba on 08-08-2017.
 */

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayListAdapter extends ArrayAdapter<PlayList> {
    private Typeface mCustomFont;
    private Context mContext;

    public PlayListAdapter(Activity context, ArrayList<PlayList> playlist) {
        super(context, 0, playlist);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Set custom typeface
        mCustomFont = Typeface.createFromAsset(mContext.getAssets(), "fonts/opensans_semibold.ttf");
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_play_list__item, parent, false);
        }
        PlayList currentPlayList = getItem(position);
        TextView textPlayList = (TextView) listItemView.findViewById(R.id.text_playlist_category);
        textPlayList.setTypeface(mCustomFont);
        textPlayList.setText(currentPlayList.getPlayList());
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_playlist_category);
        imageView.setImageResource(currentPlayList.getImageResId());
        return listItemView;
    }
}