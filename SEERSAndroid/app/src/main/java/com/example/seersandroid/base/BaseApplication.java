package com.example.seersandroid.base;


import com.example.seersandroid.Utilities.di.component.ApplicationComponent;
import com.example.seersandroid.Utilities.di.component.DaggerApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class BaseApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        ApplicationComponent component = DaggerApplicationComponent.builder().application(this).build();
        component.inject(this);

        return component;

    }
}
