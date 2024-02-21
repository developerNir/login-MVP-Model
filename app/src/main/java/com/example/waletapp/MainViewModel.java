package com.example.waletapp;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    String TAG = "MainView";

    public MainViewModel(){
        Log.d(TAG, "MainViewModel: Create a View Model");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: destroy this View Model");
    }

}
