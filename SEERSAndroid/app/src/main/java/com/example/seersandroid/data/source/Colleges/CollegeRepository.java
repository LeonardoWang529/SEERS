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
        createCollegeList();
        return Single.just(collegeList);
    }

    public void createCollegeList(){
        College c = new College("San Jose State University","CA","1 Washington Sq, San Jose, CA 95192");
        College c1 = new College("San Jose State University","CA","1 Washington Sq, San Jose, CA 95192");
        College c2 = new College("San Jose State University","CA","1 Washington Sq, San Jose, CA 95192");
        College c3 = new College("San Jose State University","CA","1 Washington Sq, San Jose, CA 95192");

        collegeList.add(c);
        collegeList.add(c1);
        collegeList.add(c2);
        collegeList.add(c3);
    }
}
