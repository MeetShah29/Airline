package com.example.mvvmjava.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmjava.model.FlightModel;
import com.example.mvvmjava.repository.FlightDataRepository;

import java.util.List;

public class FlightViewModel extends ViewModel {

    private FlightDataRepository flightDataRepository;

    public FlightViewModel() {
        flightDataRepository = new FlightDataRepository();
    }

    public MutableLiveData<List<FlightModel>> getDetailedView() {
        return flightDataRepository.getDetailedFlightData();
    }
}
