package com.example.android.musicplayerproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btn_home;
    private Button btn_search;
    private Button btn_queue;
    private Button btn_folder;
    private Button btn_profile;
    EditText edit_search;
    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, listItems);
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        scrollView = (ScrollView) findViewById(R.id.scrollView_id);
        btn_home = (Button) findViewById(R.id.btn_home);
        btn_search = (Button) findViewById(R.id.btn_search);
        btn_queue = (Button) findViewById(R.id.btn_queue_music);
        btn_folder = (Button) findViewById(R.id.btn_folder);
        btn_profile = (Button) findViewById(R.id.btn_profile);
        edit_search = (EditText) findViewById(R.id.editText_search);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.setVisibility(View.VISIBLE);
                edit_search.setVisibility(View.GONE);
            }
        });
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Folder.class);
                startActivity(intent);
            }
        });
        btn_queue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Play_Pause.class);
                startActivity(intent);
            }
        });
        btn_folder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Folder.class);
                startActivity(intent);
            }
        });
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Profile.class);
                startActivity(intent);
            }
        });
    }

    public void moveToGentleman(View view) {
        Intent intent = new Intent(MainActivity.this, New_Trending.class);
        intent.putExtra("keys", "Gentleman");
        startActivity(intent);
    }

    public void moveToToiletEkPremKatha(View view) {
        Intent intent = new Intent(MainActivity.this, New_Trending.class);
        intent.putExtra("keys", "ToiletEkPremKatha");
        startActivity(intent);
    }

    public void moveToJabHerryMetSejal(View view) {
        Intent intent = new Intent(MainActivity.this, New_Trending.class);
        intent.putExtra("keys", "JabHerryMetSejal");
        startActivity(intent);
    }

    public void moveToLataMangeshkar(View view) {
        Intent intent = new Intent(MainActivity.this, Artist.class);
        intent.putExtra("keys", "LataMangeshkar");
        startActivity(intent);
    }

    public void moveToShreyaGhosal(View view) {
        Intent intent = new Intent(MainActivity.this, Artist.class);
        intent.putExtra("keys", "ShreyaGhosal");
        startActivity(intent);
    }

    public void moveToUditNarayan(View view) {
        Intent intent = new Intent(MainActivity.this, Artist.class);
        intent.putExtra("keys", "UditNarayan");
        startActivity(intent);
    }

    public void moveToLeadingLadies(View view) {
        Intent intent = new Intent(MainActivity.this, Album.class);
        intent.putExtra("keys", "LeadingLadies");
        startActivity(intent);
    }

    public void moveToGulzar(View view) {
        Intent intent = new Intent(MainActivity.this, Album.class);
        intent.putExtra("keys", "Gulzar");
        startActivity(intent);
    }

    public void moveToRangdeBasanti(View view) {
        Intent intent = new Intent(MainActivity.this, Album.class);
        intent.putExtra("keys", "RangdeBasanti");
        startActivity(intent);
    }
}