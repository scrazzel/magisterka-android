package com.example.admin.albumsviewer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class AlbumDetails extends AppCompatActivity {

    TextView tvTitle, tvBand, tvGenre, tvPublicationDate, tvPrice;

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

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvBand = (TextView) findViewById(R.id.tvBand);
        tvGenre = (TextView) findViewById(R.id.tvGenre);
        tvPublicationDate = (TextView) findViewById(R.id.tvPublicationDate);
        tvPrice = (TextView) findViewById(R.id.tvPrice);

        //get data from intent
        String title = getIntent().getStringExtra("title");
        String band = getIntent().getStringExtra("band");

        //set data to views
        tvTitle.setText(title);
        tvBand.setText(band);




    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
