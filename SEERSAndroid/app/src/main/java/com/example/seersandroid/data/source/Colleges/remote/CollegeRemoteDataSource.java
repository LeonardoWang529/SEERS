package com.example.seersandroid.data.source.Colleges.remote;

import com.example.seersandroid.Utilities.scopes.AppScoped;
import com.example.seersandroid.data.model.College;
import com.example.seersandroid.data.source.student.remote.StudentApiService;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import io.reactivex.Single;

@AppScoped
public class CollegeRemoteDataSource {

    @NonNull
    private CollegeApiService mCollegeApiService;

    @Inject
    public CollegeRemoteDataSource(@NonNull CollegeApiService collegeApiService){
        mCollegeApiService = collegeApiService;
    }

    public Single<List<College>> getColleges(String token, String num, String page, String orderby){
        return mCollegeApiService.getCollegeList(token, num, page, orderby);
    }

    public Single<List<College>> getCollegesByName(String token, String name){
        return mCollegeApiService.getCollegeByName(token, name);
    }

}
