package com.example.waletapp.model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class UserEmliement implements IUser{

    private String email, otp;

    public UserEmliement(String email, String otp) {
        this.email = email;
        this.otp = otp;
    }


    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getOtp() {
        return otp;
    }

    @Override
    public int checkUserValidity() {

        if (TextUtils.isEmpty(getEmail())){
            return 0;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return 1;
        } else if (TextUtils.isEmpty(getOtp())) {
            return 2;
        } else if (getOtp().length()<5) {
            return 3;
        }else return -1;


    }
}
