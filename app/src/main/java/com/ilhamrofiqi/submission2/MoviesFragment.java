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
public class MoviesFragment extends Fragment implements View.OnClickListener{
    private String[] dataTitle;
    private String[] dataGenre;
    private String[] dataYear;
    private String[] dataRuntime;
    private String[] dataDirector;
    private String[] dataSynopsi;
    private TypedArray dataPhoto;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    public MoviesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv_category);
        recyclerView.setHasFixedSize(true);

        adapter = new MovieAdapter(getContext());
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Movie movie = new Movie();
                movie.setPhoto(dataPhoto.getResourceId(position, -1));
                movie.setTitle(dataTitle[position]);
                movie.setGenre(dataGenre[position]);
                movie.setSynopsi(dataSynopsi[position]);
                movie.setRuntime(dataRuntime[position]);
                movie.setDirector(dataDirector[position]);
                movie.setYear(dataYear[position]);

                Intent intent = new Intent(getActivity().getApplication(), DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.EXTRA_PERSON, movie);
                startActivity(intent);

//              Toast.makeText(getActivity().getApplication(), movies.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        prepare();
        addItem();

        return view;
    }

    private void addItem() {
        movies = new ArrayList<>();

        for (int i = 0; i < dataTitle.length; i++) {
            Movie movie = new Movie();
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            movie.setTitle(dataTitle[i]);
            movie.setGenre(dataGenre[i]);
            movie.setYear(dataYear[i]);
            movie.setRuntime(dataRuntime[i]);
            movie.setDirector(dataDirector[i]);
            movie.setSynopsi(dataSynopsi[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_movie_title);
        dataGenre = getResources().getStringArray(R.array.data_movie_genre);
        dataYear = getResources().getStringArray(R.array.data_movie_year);
        dataRuntime = getResources().getStringArray(R.array.data_movie_runtime);
        dataDirector = getResources().getStringArray(R.array.data_movie_director);
        dataSynopsi = getResources().getStringArray(R.array.data_movie_synopsi);
        dataPhoto = getResources().obtainTypedArray(R.array.data_movie_photo);
    }

    @Override
    public void onClick(View v) {

    }
}
