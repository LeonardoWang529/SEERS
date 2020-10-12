package com.example.seersandroid.data.source.Colleges;

import com.example.seersandroid.Utilities.scopes.AppScoped;
import com.example.seersandroid.data.source.Colleges.remote.CollegeApiService;
import com.example.seersandroid.data.source.Colleges.remote.CollegeRemoteDataSource;
import com.example.seersandroid.data.source.LocalDataModule;
import com.example.seersandroid.data.source.RemoteDataModule;
import com.example.seersandroid.data.source.scopes.Remote;
import com.example.seersandroid.data.source.student.StudentDataSource;
import com.example.seersandroid.data.source.student.remote.StudentApiService;
import com.example.seersandroid.data.source.student.remote.StudentRemoteDataSource;

import dagger.Module;
import dagger.Provides;

@Module(includes = {RemoteDataModule.class})
public class CollegeRepositoryModule {

    @Provides
    @Remote
    @AppScoped
    CollegeRemoteDataSource provideCollegeRemoteDataSource(CollegeApiService collegeApiService){
        return new CollegeRemoteDataSource(collegeApiService);
    }
}
