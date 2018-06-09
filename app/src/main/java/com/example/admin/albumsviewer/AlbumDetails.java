package com.example.admin.albumsviewer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class AlbumDetails extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_details);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitle("Biblioteka albumów");
        setSupportActionBar(toolbar);

        toolbar.setTitle("Szczegóły albumu");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
