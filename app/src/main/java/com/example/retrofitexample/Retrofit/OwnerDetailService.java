package com.example.retrofitexample.Retrofit;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface OwnerDetailService {







    @POST("searchVehicleDetails")
    Call<VehicleRootModel> getVehicleData(@Query("registrationNo")String no);

}
