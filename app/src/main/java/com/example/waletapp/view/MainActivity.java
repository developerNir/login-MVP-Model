package com.example.waletapp.view;


import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.ViewModelProvider;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.waletapp.R;
import com.example.waletapp.StartMainActivity;
import com.example.waletapp.presentor.ILoginPresenter;


public class MainActivity extends AppCompatActivity implements ILoginView{

    Button loginButton;
    EditText edEmail, edOtp;
    String TAG = "mainView";
    ProgressBar progressBar;

    private ILoginPresenter loginPresenter;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.loginButton);
        edEmail = findViewById(R.id.EdEmail);
        edOtp = findViewById(R.id.EdOtp);
        progressBar = findViewById(R.id.progress_circular);


        // loginPresenter object create ------------------------------
        loginPresenter = new ILoginPresenter(this);
        // progressBer InVisible --------------------------------------
        loginPresenter.setProgressBer(View.INVISIBLE);

        loginButton.setOnClickListener(view -> {
            // login presenter do Login method call -------------------
            loginPresenter.doLogin(edEmail.getText().toString().trim(), edOtp.getText().toString().trim());
            // progressBer Visible ------------------------------------
            loginPresenter.setProgressBer(View.VISIBLE);
        });










    }


    @Override
    public void setLoginSuccess(String msg) {
        loginPresenter.setProgressBer(View.INVISIBLE);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, StartMainActivity.class));

    }

    @Override
    public void setLoginError(String msg) {
        loginPresenter.setProgressBer(View.INVISIBLE);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setProgressBer(int visibility) {
        progressBar.setVisibility(visibility);
    }
}