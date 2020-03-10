package com.example.moviecataloguesub3;


import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;

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
public class TVShowFragment extends Fragment {

    ArrayList<Film> list = new ArrayList<>();
    Context mContext;

    public TVShowFragment(ArrayList<Film> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    public TVShowFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        list.addAll(getTVShow());
        View view = inflater.inflate(R.layout.fragment_tvshow, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        FilmAdapter adapter = new FilmAdapter(list, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return view;
    }

    public ArrayList<Film> getTVShow() {
        String[] titles = getResources().getStringArray(R.array.tvshow_title);
        String[] descriptions = getResources().getStringArray(R.array.tvshow_description);
        TypedArray posters = getResources().obtainTypedArray(R.array.tvshow_poster);

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
