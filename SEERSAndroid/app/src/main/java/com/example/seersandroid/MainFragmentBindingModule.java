package com.example.seersandroid;

import com.example.seersandroid.Utilities.scopes.FragmentScoped;
import com.example.seersandroid.ViewViewModel.Login.LoginFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract LoginFragment provideLoginFragment();
}
