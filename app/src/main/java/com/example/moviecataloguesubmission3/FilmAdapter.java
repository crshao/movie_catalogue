package com.example.moviecataloguesub3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {

    private ArrayList<Film> list;
    private Context mContext;

    public FilmAdapter(ArrayList<Film> list, Context context) {
        this.list = list;
        this.mContext = context;
    }

    @NonNull
    @Override
    public FilmAdapter.FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film_row, parent, false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmAdapter.FilmViewHolder holder, int position) {
        Film film = list.get(position);

//        Glide.with(mContext)
//                .load(film.getPoster())
//                .apply(new RequestOptions().override(100, 150))
//                .into(holder.poster);
        holder.poster.setImageResource(film.getPoster());

        holder.title.setText(film.getTitle());
        holder.description.setText(film.getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FilmViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView description;
        public ImageView poster;

        public FilmViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            poster = itemView.findViewById(R.id.poster);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Film film = list.get(position);
                    Intent intent = new Intent(mContext, FilmDetail.class);
                    intent.putExtra(FilmDetail.EXTRA_FILM, film);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
