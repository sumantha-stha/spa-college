package com.example.newapplication.listviews;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newapplication.R;

import java.util.ArrayList;

public class CustomListViewActivity extends AppCompatActivity {

    private ListView listView;
    private CustomListViewAdapter customAdapter;
    private ArrayList<Movie> movieArrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        listView = findViewById(R.id.customListView);
        initMovies();

        customAdapter = new CustomListViewAdapter(this,movieArrayList);
        listView.setAdapter(customAdapter);
    }

    private void initMovies() {
        movieArrayList = new ArrayList<>();

        Movie movie = new Movie("God of War",
                "4th August",
                "https://marketplace.canva.com/EAFTl0ixW_k/1/0/1131w/canva-black-white-minimal-alone-movie-poster-YZ-0GJ13Nc8.jpg");
        movieArrayList.add(movie);

        movie = new Movie("Alone",
                "12th August",
                "https://marketplace.canva.com/EAFTl0ixW_k/1/0/1131w/canva-black-white-minimal-alone-movie-poster-YZ-0GJ13Nc8.jpg");
        movieArrayList.add(movie);

        movie = new Movie("Demon",
                "12th August",
                "https://marketplace.canva.com/EAFRL_wsIbA/1/0/1131w/canva-red-and-black-horror-movie-poster-6lVWihK5Sro.jpg");
        movieArrayList.add(movie);

        movie = new Movie("Test",
                "12th August",
                "https://i.pinimg.com/736x/9d/fc/1c/9dfc1cd609a41b68fcc1f24a748239ec.jpg");
        movieArrayList.add(movie);

        movie = new Movie("Alone",
                "12th August",
                "https://marketplace.canva.com/EAFTl0ixW_k/1/0/1131w/canva-black-white-minimal-alone-movie-poster-YZ-0GJ13Nc8.jpg");
        movieArrayList.add(movie);

        movie = new Movie("Alone",
                "12th August",
                "https://marketplace.canva.com/EAFTl0ixW_k/1/0/1131w/canva-black-white-minimal-alone-movie-poster-YZ-0GJ13Nc8.jpg");
        movieArrayList.add(movie);

        movie = new Movie("Alone",
                "12th August",
                "https://marketplace.canva.com/EAFTl0ixW_k/1/0/1131w/canva-black-white-minimal-alone-movie-poster-YZ-0GJ13Nc8.jpg");
        movieArrayList.add(movie);

        movie = new Movie("Alone",
                "12th August",
                "https://marketplace.canva.com/EAFTl0ixW_k/1/0/1131w/canva-black-white-minimal-alone-movie-poster-YZ-0GJ13Nc8.jpg");
        movieArrayList.add(movie);

        movie = new Movie("Alone",
                "12th August",
                "https://marketplace.canva.com/EAFTl0ixW_k/1/0/1131w/canva-black-white-minimal-alone-movie-poster-YZ-0GJ13Nc8.jpg");
        movieArrayList.add(movie);
    }
}
