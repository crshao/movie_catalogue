package com.example.moviecataloguesub3;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    private ArrayList<Film> list = new ArrayList<>();
    private RecyclerView recyclerView;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list.addAll(getMovies());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_movie, container, false);
        recyclerView = v.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        FilmAdapter adapter = new FilmAdapter(list, getContext());
        recyclerView.setAdapter(adapter);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public ArrayList<Film> getMovies() {
        String[] titles = getResources().getStringArray(R.array.movie_title);
        String[] descriptions = getResources().getStringArray(R.array.movie_description);
        TypedArray posters = getResources().obtainTypedArray(R.array.movie_poster);

        ArrayList<Film> list = new ArrayList<>();

        for (int i = 0; i < titles.length; i++)
        {
            Film film = new Film();
            film.setTitle(titles[i]);
            film.setDescription(descriptions[i]);
            film.setPoster(posters.getResourceId(i, -1));
            list.add(film);
        }

        return list;
    }

}
