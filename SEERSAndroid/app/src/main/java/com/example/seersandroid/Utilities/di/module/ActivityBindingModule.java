package com.example.seersandroid.Utilities.di.module;

import com.example.seersandroid.MainActivity;
import com.example.seersandroid.MainFragmentBindingModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/* bind Activity to applications*/
@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {MainFragmentBindingModule.class})
    abstract MainActivity bindMainActivity();

}
