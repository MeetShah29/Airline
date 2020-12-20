package com.example.mvvmjava.model;

import android.os.Build;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.databinding.BindingAdapter;

import com.example.mvvmjava.R;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FlightModel {

    @SerializedName("Flightnr")
    private String flightNr;
    @SerializedName("Date")
    private String date;
    @SerializedName("Aircraft Type")
    private String aircraftType;
    @SerializedName("Tail")
    private String tail;
    @SerializedName("Departure")
    private String departure;
    @SerializedName("Destination")
    private String destination;
    @SerializedName("Time_Depart")
    private String departTime;
    @SerializedName("Time_Arrive")
    private String arrivalTime;
    @SerializedName("DutyID")
    private String dutyId;
    @SerializedName("DutyCode")
    private String dutyCode;
    @SerializedName("Captain")
    private String captain;
    @SerializedName("First Officer")
    private String firstOfficer;
    @SerializedName("Flight Attendant")
    private String flightAttendant;


    public String getFlightNr() {
        return flightNr;
    }

    public void setFlightNr(String flightNr) {
        this.flightNr = flightNr;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDutyId() {
        return dutyId;
    }

    public void setDutyId(String dutyId) {
        this.dutyId = dutyId;
    }

    public String getDutyCode() {
        return dutyCode;
    }

    public void setDutyCode(String dutyCode) {
        this.dutyCode = dutyCode;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public String getFirstOfficer() {
        return firstOfficer;
    }

    public void setFirstOfficer(String firstOfficer) {
        this.firstOfficer = firstOfficer;
    }

    public String getFlightAttendant() {
        return flightAttendant;
    }

    public void setFlightAttendant(String flightAttendant) {
        this.flightAttendant = flightAttendant;
    }

    public static String dateTime(String t) {
        t = "dd MMM, YYYY";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(t);
        String date = simpleDateFormat.format(new Date());
        return date;
    }

    @BindingAdapter("airport_text")
    public static void setJourney(
            TextView airportTxt,
            FlightModel model
    ) {
        if (model.getDutyCode().equals("LAYOVER")) {
            airportTxt.setCompoundDrawablesWithIntrinsicBounds
                    (R.drawable.ic_baseline_shopping_bag_24, 0, 0, 0);
        } else if (model.getDutyCode().equals("FLIGHT")) {
            airportTxt.setCompoundDrawablesWithIntrinsicBounds
                    (R.drawable.ic_baseline_flight_takeoff_24, 0, 0, 0);
        }
        airportTxt.setText(model.getDeparture() + " - " + model.destination);
    }

    @BindingAdapter("times_text")
    public static void setTiming(
            TextView timingTxt,
            FlightModel model
    ) {
        timingTxt.setText(model.getArrivalTime() + "-" + model.getDepartTime());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @BindingAdapter("disp_date")
    public static void displayDate(
            TextView textView,
            FlightModel model
    ) {
        textView.setText(dateTime(model.getDate()));
    }

}

