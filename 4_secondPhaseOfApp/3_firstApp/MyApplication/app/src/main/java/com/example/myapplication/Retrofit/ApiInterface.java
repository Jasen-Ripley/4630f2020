package com.example.myapplication.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("weather?appid=c7d971705ec1d685b9824b812a116daf&units=imperial")
    Call<Example> getWeatherData(@Query("q") String name);
}
