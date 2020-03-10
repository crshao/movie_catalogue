package com.example.moviecataloguesub3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FilmDetail extends AppCompatActivity {

    public final static String EXTRA_FILM = "extra_film";
    private TextView title;
    private TextView description;
    private ImageView poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        poster = findViewById(R.id.poster);

        Film film = getIntent().getParcelableExtra(EXTRA_FILM);

        title.setText(film.getTitle());
        description.setText(film.getDescription());
        poster.setImageResource(film.getPoster());

        //Back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //Back button
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
