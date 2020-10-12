package com.example.seersandroid.Utilities.di.component;

import android.app.Application;

import com.example.seersandroid.Utilities.di.module.ActivityBindingModule;
import com.example.seersandroid.Utilities.di.module.ContextModule;
import com.example.seersandroid.Utilities.di.module.UtilsModule;
import com.example.seersandroid.Utilities.di.module.ViewModelModule;
import com.example.seersandroid.Utilities.scopes.AppScoped;
import com.example.seersandroid.base.BaseApplication;
import com.example.seersandroid.data.source.Colleges.CollegeRepositoryModule;
import com.example.seersandroid.data.source.student.StudentRepositoryModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@AppScoped
@Component(modules = {
        StudentRepositoryModule.class,
        CollegeRepositoryModule.class,
        ContextModule.class,
        UtilsModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class,
        ViewModelModule.class})
public interface ApplicationComponent extends AndroidInjector<BaseApplication> {

    void inject(BaseApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        ApplicationComponent build();
    }
}
