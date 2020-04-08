package com.example.seersandroid.data.dao;

import com.example.seersandroid.data.model.College;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CollegeDAO {

    @GET("getTwentyCollegeData")
    Call<List<College>> getTwentyCollegeData();

    @GET("getCollegeData")
    Call<List<College>> getCollegeData();

}
