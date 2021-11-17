package com.example.tesseracttest;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {

    public static List<String> data = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
