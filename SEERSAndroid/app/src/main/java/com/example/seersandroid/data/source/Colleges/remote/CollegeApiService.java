package com.example.seersandroid.data.source.Colleges.remote;

import com.example.seersandroid.data.model.College;
import com.example.seersandroid.data.model.Student;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CollegeApiService {

    @POST("collegeList")
    Single<List<College>> getCollegeList();

}
