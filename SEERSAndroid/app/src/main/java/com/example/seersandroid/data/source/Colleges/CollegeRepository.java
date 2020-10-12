package com.example.seersandroid.data.source.Colleges;

import com.example.seersandroid.Utilities.ConnectivityUtils.OnlineChecker;
import com.example.seersandroid.Utilities.scopes.AppScoped;
import com.example.seersandroid.data.model.College;
import com.example.seersandroid.data.model.Student;
import com.example.seersandroid.data.source.Colleges.remote.CollegeRemoteDataSource;
import com.example.seersandroid.data.source.scopes.Local;
import com.example.seersandroid.data.source.scopes.Remote;
import com.example.seersandroid.data.source.student.StudentDataSource;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import io.reactivex.Single;

@AppScoped
public class CollegeRepository {

    CollegeRemoteDataSource mCollegeRemoteDataSource;
    OnlineChecker mOnlineChecker;

    List<College> collegeList = new ArrayList<>();

    @Inject
    public CollegeRepository(@Remote CollegeRemoteDataSource collegeRemoteDataSource,
                             OnlineChecker onlineChecker){
        mCollegeRemoteDataSource = collegeRemoteDataSource;
        mOnlineChecker = onlineChecker;
    }

    @NonNull
    public Single<List<College>> geColleges() {
        //return mCollegeRemoteDataSource.getColleges().doOnSuccess(res -> collegeList.addAll(res));
        return Single.just(collegeList);
    }
}
