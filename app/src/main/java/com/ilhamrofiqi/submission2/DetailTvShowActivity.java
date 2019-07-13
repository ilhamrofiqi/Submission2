package com.ilhamrofiqi.submission2;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailTvShowActivity extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";
    TextView tvtitle, tvgenre, tvsynopsi, tvruntime, tvcreator, tvyear;
    ImageView imgphoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        tvtitle = findViewById(R.id.tv_tv_show_title);
        tvgenre = findViewById(R.id.tv_tv_show_genre);
        tvsynopsi = findViewById(R.id.tv_tv_show_synopsi);
        tvruntime = findViewById(R.id.tv_tv_show_runtime);
        tvcreator = findViewById(R.id.tv_tv_show_creator);
        tvyear = findViewById(R.id.tv_tv_show_year);
        imgphoto = findViewById(R.id.img_tv_show_photo);

        TvShow tvshow = getIntent().getParcelableExtra(EXTRA_PERSON);
        int Photo = tvshow.getPhoto();
        String title = tvshow.getTitle();
        String genre = tvshow.getGenre();
        String synopsi = tvshow.getSynopsi();
        String runtime = tvshow.getRuntime();
        String creator = tvshow.getCreator();
        String year = tvshow.getYear();

        tvtitle.setText(title);
        tvgenre.setText(genre);
        tvsynopsi.setText(synopsi);
        tvruntime.setText(runtime);
        tvcreator.setText(creator);
        tvyear.setText(year);
        Glide.with(this).load(Photo).into(imgphoto);

    }
}
