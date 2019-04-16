package com.example.asynctaskdemo;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class TemperatureData extends BaseObservable{
    private String place;
    private Float temperature;

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

    public void onClick(){
        setPlace("Test");
    }


}
