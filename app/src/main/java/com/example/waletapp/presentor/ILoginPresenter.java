package com.example.waletapp.presentor;

import com.example.waletapp.model.IUser;
import com.example.waletapp.model.UserEmliement;
import com.example.waletapp.view.ILoginView;

public class ILoginPresenter implements IPresenter{

    private ILoginView loginView;

    public ILoginPresenter(ILoginView loginView){
        this.loginView = loginView;
    }

    @Override
    public void doLogin(String email, String otp) {

        IUser user = new UserEmliement(email, otp);
        int login_code = user.checkUserValidity();

        if (login_code == 0){
            loginView.setLoginError("Enter your Email");
        } else if (login_code == 1) {
            loginView.setLoginError("Invalid Email");
        } else if (login_code == 2) {
            loginView.setLoginError("Enter your Otp");
        } else if (login_code == 3) {
            loginView.setLoginError("otp must be 6 charectur");
        }else {
            loginView.setLoginSuccess("Login successful");
        }


    }

    @Override
    public void setProgressBer(int Visibility) {
        loginView.setProgressBer(Visibility);
    }
}
