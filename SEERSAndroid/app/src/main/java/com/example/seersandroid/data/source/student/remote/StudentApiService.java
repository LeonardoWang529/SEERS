package com.example.seersandroid.data.source.student.remote;

import com.example.seersandroid.data.model.Student;

import io.reactivex.Single;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface StudentApiService {

    @POST("studentlogin")
    Single<Student> login(@Query("userName") String userName, @Query("password") String password);
}

