package com.example.seersandroid.data.source.student.remote;

import com.example.seersandroid.data.RequestModel.RequestLogin;
import com.example.seersandroid.data.model.Student;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface StudentApiService {

    @Headers("Content-Type: application/json")
    @POST("user/login")
    Single<Student> login(@Body RequestLogin requestLogin);
}

