package com.example.myapplication.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Main {
    @SerializedName("temp")
    String temp;

    @SerializedName("feels_like")
    String feels_like;


    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(String feels_like) {
        this.feels_like = feels_like;
    }
}
