package com.example.seersandroid.data.dao;

import com.example.seersandroid.data.model.Student;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface StudentDAO {

    @FormUrlEncoded
    @POST("studentlogin")
    Call<Student> login(@Field("userName") String userName,@Field("password") String password);

}
