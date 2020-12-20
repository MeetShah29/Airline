package com.example.mvvmjava.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mvvmjava.R;

public class DetailInfo extends AppCompatActivity {
    TextView flightnr_tv,date_tv,aircrafttype_tv,tail_tv,
            departure_tv,destination_tv,departTime_tv,arrivalTime_tv,
            dutyId_tv,dutyCode_tv,captian_tv,firstOff_tv,firstOffAttendant_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_info);
        flightnr_tv=findViewById(R.id.flight_nr_tv);
        date_tv=findViewById(R.id.date_tv);
        aircrafttype_tv=findViewById(R.id.aircraft_type_tv);
        tail_tv=findViewById(R.id.tail_tv);
        departTime_tv=findViewById(R.id.depart_time_tv);
        departure_tv=findViewById(R.id.departure_tv);
        destination_tv=findViewById(R.id.destination_tv);
        arrivalTime_tv=findViewById(R.id.arrive_time_tv);
        dutyId_tv=findViewById(R.id.duty_id_tv);
        dutyCode_tv=findViewById(R.id.duty_code_tv);
        captian_tv=findViewById(R.id.captian_tv);
        firstOff_tv=findViewById(R.id.first_officer_tv);
        firstOffAttendant_tv=findViewById(R.id.flight_attendant_tv);


        Intent intent = getIntent();
        String flightNr = intent.getStringExtra("Flightnr");
        String date = intent.getStringExtra("Date");
        String aircraftType = intent.getStringExtra("aircraftType");
        String tail = intent.getStringExtra("Tail");
        String departure = intent.getStringExtra("Departure");
        String destination = intent.getStringExtra("Destination");
        String departureTime = intent.getStringExtra("Time_Depart");
        String arrivalTime = intent.getStringExtra("Time_Arrive");
        String dutyId = intent.getStringExtra("DutyID");
        String dutyCode = intent.getStringExtra("DutyCode");
        String captian = intent.getStringExtra("Captain");
        String firstOfficer = intent.getStringExtra("First_Officer");
        String firstOfficerAttendeant=intent.getStringExtra("Flight_Attendant");

        flightnr_tv.setText("FlightNr: "+flightNr);
        date_tv.setText("Date: "+date);
        aircrafttype_tv.setText("Aircraft Type: "+aircraftType);
        tail_tv.setText("Tail: "+tail);
        departure_tv.setText("Departure: "+departure);
        destination_tv.setText("Destination: "+destination);
        departTime_tv.setText("Departure Time: "+departureTime);
        arrivalTime_tv.setText("Arrival Time: "+arrivalTime);
        dutyId_tv.setText("Duty ID: "+dutyId);
        dutyCode_tv.setText("Duty Code: "+dutyCode);
        captian_tv.setText("Captian: "+captian);
        firstOff_tv.setText("First Officer: "+firstOfficer);
        firstOffAttendant_tv.setText("First_Officer_Attendant: "+firstOfficerAttendeant);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,MainActivity.class));
        super.onBackPressed();
    }
}