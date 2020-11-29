package com.example.seersandroid.Utilities.di.module;

import com.example.seersandroid.MainActivity;
import com.example.seersandroid.MainFragmentBindingModule;
import com.example.seersandroid.ViewViewModel.Colleges.CollegeDetailActivity;
import com.example.seersandroid.ViewViewModel.Navigation.NavigationActivity;
import com.example.seersandroid.ViewViewModel.Navigation.NavigationBindingModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/* bind Activity to applications*/
@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {MainFragmentBindingModule.class})
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {NavigationBindingModule.class})
    abstract NavigationActivity bindNavigationActivity();

    @ContributesAndroidInjector
    abstract CollegeDetailActivity bindCollegeDetailActivity();
}
