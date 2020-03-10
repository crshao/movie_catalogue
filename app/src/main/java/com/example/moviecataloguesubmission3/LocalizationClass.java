package com.example.moviecataloguesub3;

import android.app.Application;

import java.util.Locale;

public class LocalizationClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Locale locale = new Locale("");
    }
}
