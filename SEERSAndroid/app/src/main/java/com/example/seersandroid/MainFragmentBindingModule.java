package com.example.seersandroid;

import com.example.seersandroid.ViewViewModel.Login.LoginFragment;
import com.example.seersandroid.ViewViewModel.Login.SignUpFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract LoginFragment provideLoginFragment();

    @ContributesAndroidInjector
    abstract SignUpFragment provideSignUpFragment();



}
