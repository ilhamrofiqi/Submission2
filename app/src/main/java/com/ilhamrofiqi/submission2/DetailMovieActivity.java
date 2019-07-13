package com.ilhamrofiqi.submission2;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";
    TextView tvtitle, tvgenre, tvsynopsi, tvruntime, tvdirector, tvyear;
    ImageView imgphoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        tvtitle = findViewById(R.id.tv_movies_title);
        tvgenre = findViewById(R.id.tv_movies_genre);
        tvsynopsi = findViewById(R.id.tv_movies_synopsi);
        tvruntime = findViewById(R.id.tv_movies_runtime);
        tvdirector = findViewById(R.id.tv_movies_director);
        tvyear = findViewById(R.id.tv_movies_year);
        imgphoto = findViewById(R.id.img_movies_photo);

        Movie movie = getIntent().getParcelableExtra(EXTRA_PERSON);
        int Photo = movie.getPhoto();
        String title = movie.getTitle();
        String genre = movie.getGenre();
        String synopsi = movie.getSynopsi();
        String runtime = movie.getRuntime();
        String director = movie.getDirector();
        String year = movie.getYear();

        tvtitle.setText(title);
        tvgenre.setText(genre);
        tvsynopsi.setText(synopsi);
        tvruntime.setText(runtime);
        tvdirector.setText(director);
        tvyear.setText(year);
        Glide.with(this).load(Photo).into(imgphoto);

    }
}
