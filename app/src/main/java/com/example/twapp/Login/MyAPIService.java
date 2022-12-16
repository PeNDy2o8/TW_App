package com.example.twapp.Login;

import android.provider.MediaStore;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MyAPIService {
    @GET("Guardian/verify/{account}/{password}")
    Call<UserData> getAlbumsByVerify(@Path("account")String account,@Path("password")String password);
}
