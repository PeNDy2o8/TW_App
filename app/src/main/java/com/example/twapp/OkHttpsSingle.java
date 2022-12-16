package com.example.twapp;

import com.example.twapp.Login.MyAPIService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public  class  OkHttpsSingle {
    private static HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    private static OkHttpClient singleton;

    private OkHttpsSingle() {
    }

    public static OkHttpClient getOkHttp() {
        if (singleton == null) {
            synchronized (OkHttpsSingle.class) {
                if (singleton == null) {
                    singleton = new OkHttpClient();
                }
            }
        }
        return singleton;
    }

}
