package com.example.retrofitexample.Retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {







    private static OwnerDetailService ownerDetailService = null;

    public static OwnerDetailService getOwnerDetails() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                .connectTimeout(2, TimeUnit.MINUTES)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build();

        ownerDetailService = new Retrofit.Builder()
                .baseUrl("https://www.tradetu.com/bus_api/public/api/v1/vaahan/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build().create(OwnerDetailService.class);

        return ownerDetailService;
    }
}
