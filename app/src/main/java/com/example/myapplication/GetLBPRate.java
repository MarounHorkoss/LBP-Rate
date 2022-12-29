package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetLBPRate {
    @GET("/v3/b/63ad8c8a01a72b59f23ba835")
    Call<LBPRateModel> getLBPRate();
}
