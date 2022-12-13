package com.example.twapp;

import okhttp3.OkHttpClient;

public  class  OkHttpsSingle {

    private  static OkHttpClient singleton;
    private  OkHttpsSingle() {
    }
    public  static  OkHttpClient  getOkHttp()  {
        if  (singleton ==  null ) {
            synchronized  (OkHttpsSingle.class ) {
                if  (singleton ==  null ) {
                    singleton =  new  OkHttpClient();
                }
            }
        }
        return  singleton;
    }
}