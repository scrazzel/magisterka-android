package com.example.admin.albumsviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AlbumsList extends AppCompatActivity {

    Toolbar toolbar;

    RecyclerView recyclerView;
    FirebaseDatabase database;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.albums_list);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitle("Biblioteka albumów");
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("albums");
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Album, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Album, ViewHolder>(
                        Album.class,
                        R.layout.row,
                        ViewHolder.class,
                        databaseReference
                ) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, Album model, int position) {
                viewHolder.setDetails(getApplicationContext(), model.getNazwa(), model.getWykonawca(),model.getOkladkaAlbumu(),
                        model.getLogoZespolu(), model.getInfo().getGatunek(), model.getInfo().getCena(), model.getInfo().getRokWydania());
            }

                    @Override
                    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                        ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);

                        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                TextView albumTitle = view.findViewById(R.id.albumTitle);
                                TextView albumBand = view.findViewById(R.id.albumBand);
                                TextView albumGenre = view.findViewById(R.id.albumGenre);
                                TextView albumPrice = view.findViewById(R.id.albumPrice);
                                TextView albumPublicationDate = view.findViewById(R.id.albumPublicationDate);
                                //TextView tvGenre = view.findViewById(R.id.);
                                //TextView tvPublicationDate = view.findViewById(R.id.tvPublicationDate);
                                //TextView tvPrice = view.findViewById(R.id.tvPrice);

                                String mTitle = albumTitle.getText().toString();
                                String mBand = albumBand.getText().toString();
                                String mGenre = albumGenre.getText().toString();
                                String mPrice = albumPrice.getText().toString();
                                String mPublicationDate = albumPublicationDate.getText().toString();

                                // tutaj jeszcze dociagal obrazek

                                Intent intent = new Intent(view.getContext(), AlbumDetails.class);

                                intent.putExtra("title", mTitle);
                                intent.putExtra("band", mBand);
                                intent.putExtra("genre", mGenre);
                                intent.putExtra("price", mPrice);
                                intent.putExtra("publicationDate", mPublicationDate);

                                startActivity(intent);
                            }

                            @Override
                            public void onItemLongClick(View view, int position) {

                            }
                        });
                        return viewHolder;
                    }
                };

        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.logout,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int resID = item.getItemId();
        if (resID == R.id.logout){
            // mechanizm wylogowania z firebase
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(AlbumsList.this, "Wylogowałeś się!", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(AlbumsList.this, MainActivity.class));
        }

        return true;
    }
}
