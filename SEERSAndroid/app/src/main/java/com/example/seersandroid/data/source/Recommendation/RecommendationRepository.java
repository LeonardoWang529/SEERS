package com.example.seersandroid.data.source.Recommendation;

import com.example.seersandroid.Utilities.ConnectivityUtils.OnlineChecker;
import com.example.seersandroid.Utilities.scopes.AppScoped;
import com.example.seersandroid.data.model.College;
import com.example.seersandroid.data.model.Student;
import com.example.seersandroid.data.source.Colleges.remote.CollegeRemoteDataSource;
import com.example.seersandroid.data.source.Recommendation.remote.RecommendationRemoteDataSource;
import com.example.seersandroid.data.source.scopes.Remote;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import io.reactivex.Single;


@AppScoped
public class RecommendationRepository {

    RecommendationRemoteDataSource mRecommendationRemoteDataSource;
    OnlineChecker mOnlineChecker;
    List<College> collegeList = new ArrayList<>();

    @Inject
    public RecommendationRepository(@Remote RecommendationRemoteDataSource recommendationRemoteDataSource,
                             OnlineChecker onlineChecker){
        mRecommendationRemoteDataSource = recommendationRemoteDataSource;
        mOnlineChecker = onlineChecker;
    }

    public Single<List<College>> getSchoolRecommendation(Student student){
        return mRecommendationRemoteDataSource.getSchoolRecommendation(student);
    }


}
