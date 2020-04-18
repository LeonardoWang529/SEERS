package com.example.seersandroid.ViewViewModel.Login;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.example.seersandroid.data.loginModule.LoginDataSource;
import com.example.seersandroid.data.loginModule.LoginRepository;

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
public class LoginViewModelFactory implements ViewModelProvider.Factory {

    private Application mApplication;


    public LoginViewModelFactory(Application application) {
        mApplication = application;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(LoginRepository.getInstance(new LoginDataSource(mApplication)));
        } else {
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}
