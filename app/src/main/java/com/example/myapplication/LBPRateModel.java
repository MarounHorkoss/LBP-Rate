package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class LBPRateModel {
    @SerializedName("Date")
    private String date;
    @SerializedName("LBP_Rate_Buy")
    private String lbpRateBuy;
    @SerializedName("LBP_Rate_Sell")
    private String lbpRateSell;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLbpRateBuy() {
        return lbpRateBuy;
    }

    public void setLbpRateBuy(String lbpRateBuy) {
        this.lbpRateBuy = lbpRateBuy;
    }

    public String getLbpRateSell() {
        return lbpRateSell;
    }

    public void setLbpRateSell(String lbpRateSell) {
        this.lbpRateSell = lbpRateSell;
    }
}
