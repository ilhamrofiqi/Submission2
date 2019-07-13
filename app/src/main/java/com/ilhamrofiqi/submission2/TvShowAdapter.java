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

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.CategoryViewHolder>{
    private Context context;
    private ArrayList<TvShow> tvshows;

    public TvShowAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<TvShow> getTvshows() {
        return tvshows;
    }

    public void setTvshows(ArrayList<TvShow> tvshows) {
        this.tvshows = tvshows;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_tv_show, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.tvTitle.setText(getTvshows().get(i).getTitle());
        categoryViewHolder.tvGenre.setText(getTvshows().get(i).getGenre());
        categoryViewHolder.tvYear.setText(getTvshows().get(i).getYear());
        categoryViewHolder.imgPhoto.setImageResource(getTvshows().get(i).getPhoto());
    }

    @Override
    public int getItemCount() {
        return getTvshows().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvGenre, tvYear;
        ImageView imgPhoto;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_tv_show_title);
            tvGenre = itemView.findViewById(R.id.tv_tv_show_genre);
            tvYear = itemView.findViewById(R.id.tv_tv_show_year);
            imgPhoto = itemView.findViewById(R.id.img_tv_show_photo);
        }
    }
}
