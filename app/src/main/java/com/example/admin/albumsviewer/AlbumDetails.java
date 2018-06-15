package com.example.admin.albumsviewer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class AlbumDetails extends AppCompatActivity {

    Toolbar toolbar;
    TextView detailsTitle, detailsBand, detailsGenre, detailsPublicationDate, detailsPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_details);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Informacje o albumie");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        detailsTitle = (TextView) findViewById(R.id.detailsTitle);
        detailsBand = (TextView) findViewById(R.id.detailsBand);
        detailsGenre = (TextView) findViewById(R.id.detailsGenre);
        detailsPrice = (TextView) findViewById(R.id.detailsPrice);
        detailsPublicationDate = (TextView) findViewById(R.id.detailsPublicationDate);

        detailsTitle.setText(getIntent().getStringExtra("title"));
        detailsBand.setText(getIntent().getStringExtra("band"));
        detailsGenre.setText(getIntent().getStringExtra("genre"));
        detailsPrice.setText(getIntent().getStringExtra("price") + " zł");
        detailsPublicationDate.setText(getIntent().getStringExtra("publicationDate"));

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
