package com.example.android.musicplayerproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class New_Trending extends AppCompatActivity {
    private Button btn_home;
    private Button btn_search;
    private Button btn_queue;
    private Button btn_folder;
    private Button btn_profile;
    EditText edit_search;
    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__trending);
        adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, listItems);
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        Intent iin = getIntent();
        final String message = iin.getStringExtra("keys");
        btn_home = (Button) findViewById(R.id.btn_home);
        btn_search = (Button) findViewById(R.id.btn_search);
        btn_queue = (Button) findViewById(R.id.btn_queue_music);
        btn_folder = (Button) findViewById(R.id.btn_folder);
        btn_profile = (Button) findViewById(R.id.btn_profile);
        edit_search = (EditText) findViewById(R.id.editText_search);
        imageView = (ImageView) findViewById(R.id.image_newtrending);
        if (message.equals("Gentleman")) {
            imageView.setImageResource(R.drawable.agentleman);
            listItems.add("Dil Kya Kare");
        }
        if (message.equals("ToiletEkPremKatha")) {
            imageView.setImageResource(R.drawable.toiletekpremkatha);
            listItems.add("Man Dole Mera Tan Dole");
        }
        if (message.equals("JabHerryMetSejal")) {
            imageView.setImageResource(R.drawable.jabherrymet);
            listItems.add("Pardesiyon Se Na");
        }
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_search.setVisibility(View.GONE);
                Intent intent = new Intent(New_Trending.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_search.setVisibility(View.VISIBLE);
            }
        });
        edit_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                New_Trending.this.adapter.getFilter().filter(editable);
            }
        });
        btn_queue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(New_Trending.this, Play_Pause.class);
                startActivity(intent);
            }
        });
        btn_folder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(New_Trending.this, Folder.class);
                startActivity(intent);
            }
        });
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(New_Trending.this, Profile.class);
                startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = (String) (listView.getItemAtPosition(i));
                Toast toast = Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(New_Trending.this, Play_Pause.class);
                intent.putExtra("keys", String.valueOf(selected));
                startActivity(intent);
            }
        });
    }

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
                Toast.makeText(New_Trending.this, "Updating soon", Toast.LENGTH_LONG).show();
                return (true);
            case R.id.help:
                Toast.makeText(New_Trending.this, "Updating soon", Toast.LENGTH_LONG).show();
                return (true);
            case R.id.settings:
                Toast.makeText(New_Trending.this, "Updating soon", Toast.LENGTH_LONG).show();
                return (true);
            case R.id.expanded_menu:
                Toast.makeText(New_Trending.this, "Updating soon", Toast.LENGTH_LONG).show();
                return (true);
            case R.id.exit:
                System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
}

