package com.example.mvvmjava.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;

import com.example.mvvmjava.R;
import com.example.mvvmjava.adapter.FlightListAdapter;
import com.example.mvvmjava.databinding.ActivityMainBinding;
import com.example.mvvmjava.model.FlightModel;
import com.example.mvvmjava.viewmodel.FlightViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private FlightViewModel viewModel;
    private List<FlightModel> dataList = new ArrayList<>();
    private ActivityMainBinding binding;
    private FlightListAdapter adapter;
    public SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        swipeRefreshLayout = binding.swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(this);
        doIntialization();
        isConnected();
    }

    @Override
    protected void onStart() {
        doIntialization();
        super.onStart();
    }

    public void getDetails() {
        viewModel.getDetailedView().observe(this, movieModels -> {
            adapter.setFlightList((List<FlightModel>) movieModels);
            swipeRefreshLayout.setRefreshing(false);
        });
    }

    public void doIntialization() {
        RecyclerView recyclerView = binding.flightRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        viewModel = new ViewModelProvider(this).get(FlightViewModel.class);
        adapter = new FlightListAdapter(this);
        swipeRefreshLayout.setRefreshing(true);
        isConnected();
        recyclerView.setAdapter(adapter);
        getDetails();
    }

    @Override
    public void onRefresh() {
        getRepoData();
        doIntialization();
    }

    public MutableLiveData<List<FlightModel>> getRepoData() {
        return viewModel.getDetailedView();
    }

    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("No internet connection available")
                .setCancelable(false)
                .setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.finish();
                System.exit(0);
            }
        });
        builder.show();

    }

    private void isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo connection = connectivityManager.getActiveNetworkInfo();

        if (connection == null || !connection.isConnected() || !connection.isAvailable()) {
            showCustomDialog();
        }
    }
}