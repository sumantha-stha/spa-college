package com.example.newapplication.listviews;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.newapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomListViewAdapter extends ArrayAdapter<Movie> {
    private ArrayList<Movie> movieArrayList;
    public Activity context;

    public CustomListViewAdapter(Activity context, ArrayList<Movie> movieArrayList) {
        super(context, R.layout.item_movie, movieArrayList);
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.item_movie, parent, false);

        TextView textViewTitle = view.findViewById(R.id.textViewMovieTitle);
        TextView textViewRelease = view.findViewById(R.id.textViewReleaseDate);
        ImageView imageViewMovie = view.findViewById(R.id.imageViewMovie);

        Movie movie = movieArrayList.get(position);

        textViewTitle.setText(movie.getTitle());
        textViewRelease.setText(movie.getReleaseDate());

        Picasso.get().load(movie.getImageUrl()).into(imageViewMovie);

        return view;
    }
}
