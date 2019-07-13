package com.ilhamrofiqi.submission2;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment implements View.OnClickListener{
    private String[] dataTitle;
    private String[] dataGenre;
    private String[] dataYear;
    private String[] dataRuntime;
    private String[] dataCreator;
    private String[] dataSynopsi;
    private TypedArray dataPhoto;
    private TvShowAdapter adapter;
    private ArrayList<TvShow> tvshows;

    public TvShowFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv_show, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv_category);
        recyclerView.setHasFixedSize(true);

        adapter = new TvShowAdapter(getContext());
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                TvShow tvshow = new TvShow();
                tvshow.setPhoto(dataPhoto.getResourceId(position, -1));
                tvshow.setTitle(dataTitle[position]);
                tvshow.setGenre(dataGenre[position]);
                tvshow.setSynopsi(dataSynopsi[position]);
                tvshow.setRuntime(dataRuntime[position]);
                tvshow.setCreator(dataCreator[position]);
                tvshow.setYear(dataYear[position]);

                Intent intent = new Intent(getActivity().getApplication(), DetailTvShowActivity.class);
                intent.putExtra(DetailTvShowActivity.EXTRA_PERSON, tvshow);
                startActivity(intent);

            }
        });

        prepare();
        addItem();

        return view;
    }

    private void addItem() {
        tvshows = new ArrayList<>();

        for (int i = 0; i < dataTitle.length; i++) {
            TvShow tvshow = new TvShow();
            tvshow.setPhoto(dataPhoto.getResourceId(i, -1));
            tvshow.setTitle(dataTitle[i]);
            tvshow.setGenre(dataGenre[i]);
            tvshow.setYear(dataYear[i]);
            tvshow.setRuntime(dataRuntime[i]);
            tvshow.setCreator(dataCreator[i]);
            tvshow.setSynopsi(dataSynopsi[i]);
            tvshows.add(tvshow);
        }
        adapter.setTvshows(tvshows);
    }

    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_tv_show_title);
        dataGenre = getResources().getStringArray(R.array.data_tv_show_genre);
        dataYear = getResources().getStringArray(R.array.data_tv_show_year);
        dataRuntime = getResources().getStringArray(R.array.data_tv_show_runtime);
        dataCreator = getResources().getStringArray(R.array.data_tv_show_creator);
        dataSynopsi = getResources().getStringArray(R.array.data_tv_show_synopsi);
        dataPhoto = getResources().obtainTypedArray(R.array.data_tv_show_photo);
    }

    @Override
    public void onClick(View v) {

    }

}
