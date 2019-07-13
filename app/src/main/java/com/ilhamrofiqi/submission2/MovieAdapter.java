package com.ilhamrofiqi.submission2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.CategoryViewHolder> {

    private Context context;
    private ArrayList<Movie> movies;

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_movies, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.tvTitle.setText(getMovies().get(i).getTitle());
        categoryViewHolder.tvGenre.setText(getMovies().get(i).getGenre());
        categoryViewHolder.tvYear.setText(getMovies().get(i).getYear());
        categoryViewHolder.imgPhoto.setImageResource(getMovies().get(i).getPhoto());
    }

    @Override
    public int getItemCount() {
        return getMovies().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvGenre, tvYear;
        ImageView imgPhoto;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_movies_title);
            tvGenre = itemView.findViewById(R.id.tv_movies_genre);
            tvYear = itemView.findViewById(R.id.tv_movies_year);
            imgPhoto = itemView.findViewById(R.id.img_movies_photo);
        }
    }
}
