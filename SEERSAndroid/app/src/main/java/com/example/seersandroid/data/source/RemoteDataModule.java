package com.example.seersandroid.data.source;

import com.example.seersandroid.Utilities.scopes.AppScoped;
import com.example.seersandroid.data.source.Colleges.remote.CollegeApiService;
import com.example.seersandroid.data.source.student.remote.StudentApiService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.seersandroid.Utilities.Constants.SEERS_API_BASE_URL;

@Module
public class RemoteDataModule {

    @AppScoped
    @Provides
    StudentApiService provideStudentsApiService(Retrofit retrofit) {
        return retrofit.create(StudentApiService.class);
    }

    @AppScoped
    @Provides
    CollegeApiService provideCollegeApiService(Retrofit retrofit) {
        return retrofit.create(CollegeApiService.class);
    }

    @Provides
    @AppScoped
    Retrofit provideRetrofit(Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(SEERS_API_BASE_URL)
                .build();
    }

    @Provides
    @AppScoped
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }
}
