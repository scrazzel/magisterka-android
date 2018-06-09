package com.example.admin.albumsviewer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder{

    View mView;

    public ViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
    }

    public void setDetails(Context ctx, String title, String band, String cover, String logo){
        TextView albumTitle = (TextView) mView.findViewById(R.id.albumTitle);
        TextView albumBand = (TextView) mView.findViewById(R.id.albumBand);
        ImageView albumCover = (ImageView) mView.findViewById(R.id.albumCover);
        ImageView albumBandLogo = (ImageView) mView.findViewById(R.id.albumBandLogo);

        albumTitle.setText(title);
        albumBand.setText(band);
        Picasso.get().load(cover).into(albumCover);
        Picasso.get().load(logo).into(albumBandLogo);


    }
}
