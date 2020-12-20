package com.example.mvvmjava.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmjava.model.FlightModel;
import com.example.mvvmjava.ui.DetailInfo;
import com.example.mvvmjava.R;
import com.example.mvvmjava.databinding.ScheduleLayoutBinding;

import java.util.List;

public class FlightListAdapter extends RecyclerView.Adapter<FlightListAdapter.MyViewHolder> {
    private Context context;
    private List<FlightModel> modelData;
    private LayoutInflater layoutInflater;

    public FlightListAdapter(Context context) {
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ScheduleLayoutBinding scheduleLayoutBinding;
        ConstraintLayout constraintLayout;

        public MyViewHolder(ScheduleLayoutBinding scheduleLayoutBinding) {
            super(scheduleLayoutBinding.getRoot());
            this.scheduleLayoutBinding = scheduleLayoutBinding;
            constraintLayout= scheduleLayoutBinding.flightInfo;
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ScheduleLayoutBinding binding = DataBindingUtil
                .inflate(layoutInflater, R.layout.schedule_layout, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        FlightModel jsonData = modelData.get(position);
        holder.scheduleLayoutBinding.setModel(jsonData);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailInfo.class);
                intent.putExtra("Flightnr",jsonData.getFlightNr());
                intent.putExtra("Date",jsonData.getDate());
                intent.putExtra("aircraftType", jsonData.getAircraftType());
                intent.putExtra("Tail",jsonData.getTail());
                intent.putExtra("Departure",jsonData.getDeparture());
                intent.putExtra("Destination",jsonData.getDestination());
                intent.putExtra("Time_Depart",jsonData.getDepartTime());
                intent.putExtra("Time_Arrive",jsonData.getArrivalTime());
                intent.putExtra("DutyID",jsonData.getDutyId());
                intent.putExtra("DutyCode",jsonData.getDutyCode());
                intent.putExtra("Captain",jsonData.getCaptain());
                intent.putExtra("First_Officer",jsonData.getFirstOfficer());
                intent.putExtra("Flight_Attendant",jsonData.getFlightAttendant());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (modelData != null) {
            return modelData.size();
        } else {
            return 0;
        }
    }

    public void setFlightList(List<FlightModel> modelData) {
        this.modelData = modelData;
        notifyDataSetChanged();
    }
}
