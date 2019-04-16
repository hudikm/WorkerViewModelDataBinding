package com.example.asynctaskdemo;

import android.content.res.ColorStateList;
import android.widget.ProgressBar;

import java.util.Random;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

public class TemperatureData extends BaseObservable {
    private String place;
    private Float temperature;
    private static final String[] Locations = {"Bratislava", "Zilina", "Martin", "Ruzomberok", "Trnava", "Kosice", "Poprad", "Presov"};

    public TemperatureData(String place, Float temperature) {
        this.place = place;
        this.temperature = temperature;
    }

    @Bindable
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
        notifyPropertyChanged(BR.place);
    }

    @Bindable
    public Float getTemperature() {
        return temperature;
    }


    public void setTemperature(Float temperature) {
        this.temperature = temperature;
        notifyPropertyChanged(BR.temperature);
    }

    public void onClick() {
        setTemperature((float) getRandomNumberInRange(-50, 50));
    }

    /**
     * Sets the value of the progress bar.
     */
    @BindingAdapter("android:setProgress")
    public static void setProgress(ProgressBar progressBar, float temperature) {
        progressBar.setProgress((int) temperature + 50);
        int color = 0x5841f400;
        if (temperature <= -30)
            color = 0xff7041f4;
        else if (temperature <= -20)
            color = 0xff4176f4;
        else if (temperature <= -10)
            color = 0xff41cdf4;
        else if (temperature <= 0)
            color = 0xff41f4d9;
        else if (temperature <= 10)
            color = 0xff41f458;
        else if (temperature <= 20)
            color = 0xfff4e541;
        else if (temperature <= 30)
            color = 0xfff4a941;
        else
            color = 0xfff44141;

        progressBar.setProgressTintList(ColorStateList.valueOf(color));

    }

    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static String getRandomLocation() {
        int index = getRandomNumberInRange(0, Locations.length - 1);
        return Locations[index];
    }

}
