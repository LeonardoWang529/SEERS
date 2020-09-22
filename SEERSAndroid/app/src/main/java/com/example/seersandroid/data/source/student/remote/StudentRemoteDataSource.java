package com.example.seersandroid.data.source.student.remote;

import com.example.seersandroid.Utilities.scopes.AppScoped;
import com.example.seersandroid.data.model.Student;
import com.example.seersandroid.data.source.student.StudentDataSource;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import io.reactivex.Single;

@AppScoped
public class StudentRemoteDataSource implements StudentDataSource {

    @NonNull
    private StudentApiService mStudentApiService;

    @Inject
    public StudentRemoteDataSource(@NonNull StudentApiService studentApiService){
        mStudentApiService = studentApiService;
    }

    @NonNull
    @Override
    public Single<Student> getStudent(@NonNull String userName, @NonNull String password) {
        return null;
    }

    @Override
    public void deleteStudent() {

    }

    @Override
    public void saveStudent(@NonNull Student student) {

    }
}
