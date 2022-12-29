package com.example.myapplication;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {

    private TextView date;
    private TextView lbpRateBuy;
    private TextView lbpRateSell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = findViewById(R.id.date);
        lbpRateBuy = findViewById(R.id.buy);
        lbpRateSell = findViewById(R.id.sell);

        getLBPRate();

    }

    private void getLBPRate() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.jsonbin.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetLBPRate getLBPRate = retrofit.create(GetLBPRate.class);

        Call<LBPRateModel> call = getLBPRate.getLBPRate();
        call.enqueue(new Callback<LBPRateModel>() {
            @Override
            public void onResponse(Call<LBPRateModel> call, Response<LBPRateModel> response) {
                if (response.isSuccessful()){
                    LBPRateModel lbpRateModel = response.body();
                    date.setText(lbpRateModel.getDate());
                    date.setText("9 Hours ago");
                    lbpRateBuy.setText(lbpRateModel.getLbpRateBuy());
                    lbpRateBuy.setText("42000");
                    lbpRateSell.setText(lbpRateModel.getLbpRateSell());
                    lbpRateSell.setText("41500");
                }
            }

            @Override
            public void onFailure(Call<LBPRateModel> call, Throwable t) {
                Log.e("Error : ", t.getMessage());
            }
        });
    }
}