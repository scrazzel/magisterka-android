package com.example.admin.albumsviewer;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;

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

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        Album album = snapshot.getValue(Album.class);
                        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaaa");
                        System.out.println(album.getInfo().getGatunek());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
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
                        model.getLogoZespolu());
            }

            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                final ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
                viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        TextView tvTitle = view.findViewById(R.id.albumTitle);
                        TextView tvBand = view.findViewById(R.id.albumBand);
                        //TextView tvGenre = view.findViewById(R.id.);
                        //TextView tvPublicationDate = view.findViewById(R.id.tvPublicationDate);
                        //TextView tvPrice = view.findViewById(R.id.tvPrice);

                        String mTitle = tvTitle.getText().toString();
                        String mBand = tvBand.getText().toString();

                        // tutaj jeszcze dociagal obrazek

                        Intent intent = new Intent(view.getContext(), AlbumDetails.class);

                        intent.putExtra("title", mTitle);
                        intent.putExtra("band", mBand);

                        Query query = FirebaseDatabase.getInstance().getReference("albums").orderByChild("title").equalTo(mTitle);

                        query.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if (dataSnapshot.exists()){
                                    Album album = dataSnapshot.getValue(Album.class);
                                    int price = album.getInfo().getCena();
                                    System.out.println("CENA ALBUMU =========================" + String.valueOf(price));
                                    /*
                                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                                        Album album = snapshot.getValue(Album.class);

                                        Album albumTest = snapshot.getValue(Album.class);
                                        //int cena = snapshot.getValue(Album.class);

                                        System.out.print("dupa");
                                        //System.out.println(String.valueOf(cena));

                                    }
                                    */
                                }

                                //dataSnapshot.ge
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });


                        //System.out.println("WARTOSC QUERYYYYYYYYYYYY => " + query.toString());

                        //Log.d("test", query.toString());
                       // Log.e("test", query.toString());

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
