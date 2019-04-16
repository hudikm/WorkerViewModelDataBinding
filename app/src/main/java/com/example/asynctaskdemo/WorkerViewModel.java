package com.example.asynctaskdemo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

public class WorkerViewModel extends ViewModel {
    private List<TemperatureData> data = new ArrayList<>();
    private AsyncTask<Void, TemperatureData, Void> asyncTask;
    private MutableLiveData<List<TemperatureData>> mutableLiveData = new MutableLiveData<>();

    public MutableLiveData<List<TemperatureData>> getMutableLiveData() {
        return mutableLiveData;
    }

    public void runAsyncTask() {
        if (asyncTask == null)
            asyncTask = new AsyncTaskWorker().execute();
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        asyncTask.cancel(true);
    }

    public class AsyncTaskWorker extends AsyncTask<Void, TemperatureData, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            int i = 0;
            while (true) {
                try {
                    publishProgress(new TemperatureData("Skuska", (float) i++));
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    if (isCancelled()) return null;
                }

            }
        }

        @Override
        protected void onProgressUpdate(TemperatureData... values) {
            super.onProgressUpdate(values);
            data.add(values[0]);
            mutableLiveData.setValue(data);
        }
    }
}


