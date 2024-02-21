package com.example.waletapp.model;

public interface IUser {
    String getEmail();
    String getOtp();
    int checkUserValidity();
}
