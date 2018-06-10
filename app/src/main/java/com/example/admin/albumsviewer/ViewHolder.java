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

        //item click
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        });

        // item long click
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mClickListener.onItemLongClick(view, getAdapterPosition());
                return true;
            }
        });
    }

    public void setDetails(Context ctx, String title, String band, String cover, String logo, String genre, double price, int publicationDate){
        TextView albumTitle = (TextView) mView.findViewById(R.id.albumTitle);
        TextView albumBand = (TextView) mView.findViewById(R.id.albumBand);

        // dodatki
        TextView albumGenre = (TextView) mView.findViewById(R.id.albumGenre);
        TextView albumPrice = (TextView) mView.findViewById(R.id.albumPrice);
        TextView albumPublicationDate = (TextView) mView.findViewById(R.id.albumPublicationDate);


        ImageView albumCover = (ImageView) mView.findViewById(R.id.albumCover);
        ImageView albumBandLogo = (ImageView) mView.findViewById(R.id.albumBandLogo);

        albumTitle.setText(title);
        albumBand.setText(band);
        albumGenre.setText(genre);
        albumPrice.setText(String.valueOf(price));
        albumPublicationDate.setText(String.valueOf(publicationDate));

        Picasso.get().load(cover).into(albumCover);
        Picasso.get().load(logo).into(albumBandLogo);

    }

    private ViewHolder.ClickListener mClickListener;

    public interface ClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public void setOnClickListener(ViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }
}
