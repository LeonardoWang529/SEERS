package com.example.seersandroid.data.source.Colleges.remote;

import com.example.seersandroid.data.model.College;
import com.example.seersandroid.data.model.Student;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CollegeApiService {

    @Headers("Content-Type: application/json")
    @GET("college/order")
    Single<List<College>> getCollegeList(@Header("Authorization") String token,@Query("num") String num, @Query("page") String page,
                                         @Query("orderby") String orderby);


    @Headers("Content-Type: application/json")
    @GET("/college/name")
    Single<List<College>> getCollegeByName(@Header("Authorization") String token,@Query("name") String name);

}
