package com.example.mvvmjava.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {

    public static String BASE_URL="https://www.rosterbuster.aero/wp-content/uploads/";
    private static Retrofit retrofit;

    public static Retrofit getRetroClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public APIService getApi() {
        return retrofit.create(APIService.class);
    }
}
