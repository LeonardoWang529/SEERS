package com.example.seersandroid.data.source.student;

import com.example.seersandroid.Utilities.schedulers.BaseSchedulerProvider;
import com.example.seersandroid.Utilities.scopes.AppScoped;
import com.example.seersandroid.data.source.LocalDataModule;
import com.example.seersandroid.data.source.RemoteDataModule;
import com.example.seersandroid.data.source.scopes.Local;
import com.example.seersandroid.data.source.scopes.Remote;
import com.example.seersandroid.data.source.student.local.StudentDao;
import com.example.seersandroid.data.source.student.local.StudentLocalDataSource;
import com.example.seersandroid.data.source.student.remote.StudentApiService;
import com.example.seersandroid.data.source.student.remote.StudentRemoteDataSource;

import dagger.Module;
import dagger.Provides;

@Module(includes = {LocalDataModule.class, RemoteDataModule.class})
public class StudentRepositoryModule {
    @Provides
    @Local
    @AppScoped
    StudentDataSource provideStudentLocalDataSource(StudentDao studentDao,
                                                    BaseSchedulerProvider baseSchedulerProvider){
        return new StudentLocalDataSource(studentDao,baseSchedulerProvider);
    }

    @Provides
    @Remote
    @AppScoped
    StudentDataSource provideStudentRemoteDataSource(StudentApiService studentApiService){
        return new StudentRemoteDataSource(studentApiService);
    }

}
