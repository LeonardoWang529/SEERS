package com.example.seersandroid.Utilities.di.module;

import com.example.seersandroid.Utilities.scopes.AppScoped;
import com.example.seersandroid.data.dao.StudentDAO;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public class ApplicationModule {

    private static final String BASE_URL = "https://api.github.com/";

    @Provides
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    static StudentDAO provideStudentService(Retrofit retrofit) {
        return retrofit.create(StudentDAO.class);
    }
}
