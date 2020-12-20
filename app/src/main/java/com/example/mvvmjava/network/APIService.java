package com.example.mvvmjava.network;

import com.example.mvvmjava.model.FlightModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("dummy-response.json")
    Call<List<FlightModel>> getApiData();
}
