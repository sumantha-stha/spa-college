package com.example.newapplication.listviews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {

    private ArrayList<Movie> movieArrayList;

    public RecyclerViewAdapter(ArrayList<Movie> movieArrayList) {
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.CustomViewHolder holder, int position) {
        Movie movie = movieArrayList.get(position);

        holder.textviewTitle.setText(movie.getTitle());
        holder.textviewReleaseDate.setText(movie.getReleaseDate());

        Picasso.get().load(movie.getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView textviewTitle, textviewReleaseDate;
        ImageView imageView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            textviewTitle = itemView.findViewById(R.id.textViewMovieTitle);
            textviewReleaseDate = itemView.findViewById(R.id.textViewReleaseDate);
            imageView = itemView.findViewById(R.id.imageViewMovie);
        }
    }
}
