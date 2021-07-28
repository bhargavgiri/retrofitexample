        package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofitexample.Retrofit.ApiClient;
import com.example.retrofitexample.Retrofit.OwnerDetailService;
import com.example.retrofitexample.Retrofit.VehicleRootModel;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        
        OwnerDetailService ownerDetailService=ApiClient.getOwnerDetails();
        Call<VehicleRootModel> call=ownerDetailService.getVehicleData("GJ S6631");
        call.enqueue(new Callback<VehicleRootModel>() {
            @Override
            public void onResponse(Call<VehicleRootModel> call, Response<VehicleRootModel> response) {
                if(response.isSuccessful())
                {
                   VehicleRootModel vehicleRootModel=response.body();
                   String on=vehicleRootModel.getDetails().getOwnerName();

                }
            }
            @Override
            public void onFailure(Call<VehicleRootModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Response FAil !!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}