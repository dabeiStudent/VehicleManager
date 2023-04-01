package com.example.vehiclemanager;

import com.bumptech.glide.annotation.GlideExtension;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
    @GET("api/auth/profile")
    Call<User> getprofile();
    @FormUrlEncoded
    @POST("api/auth/login")
    Call<User> login (@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("api/auth/signup")
    Call<User> signup (@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);

}
