package com.example.seersandroid.data;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofits {
    public Retrofit retrofit;
    static Retrofits retrofits;

    private Retrofits(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static synchronized Retrofits getInstance(){
        if(retrofits == null){
            try {
                retrofits = new Retrofits();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return retrofits;
    }

}
