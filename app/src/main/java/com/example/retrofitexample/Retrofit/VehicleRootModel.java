package com.example.retrofitexample.Retrofit;

import android.telecom.Call;

import com.google.gson.annotations.SerializedName;

public class VehicleRootModel {






    String statusCode;
    String statusMessage;
    public Details details;

    public Details getDetails() {
        return details;
    }
    public String getStatusCode() {
        return statusCode;
    }
    public String getStatusMessage() {
        return statusMessage;
    }
}
