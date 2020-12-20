package com.example.mvvmjava.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmjava.model.FlightModel;
import com.example.mvvmjava.network.APIService;
import com.example.mvvmjava.network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlightDataRepository {
    private APIService apiService;

    public FlightDataRepository() {
        apiService = RetroInstance.getRetroClient().create(APIService.class);
    }

    public MutableLiveData<List<FlightModel>>getDetailedFlightData() {
        MutableLiveData<List<FlightModel>> data = new MutableLiveData<>();
        apiService.getApiData().enqueue(new Callback<List<FlightModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<FlightModel>> call, @NonNull Response<List<FlightModel>> response) {
                data.setValue(response.body());
                System.out.println("Great success" + response.body().toString());

            }

            @Override
            public void onFailure(@NonNull Call<List<FlightModel>> call, @NonNull Throwable t) {
                Log.i("Failure",t.getLocalizedMessage());
            }

        });
        return data;
    }

}
