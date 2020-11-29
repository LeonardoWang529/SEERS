package com.example.seersandroid.data.source.Recommendation.remote;

import com.example.seersandroid.Utilities.scopes.AppScoped;
import com.example.seersandroid.data.model.College;
import com.example.seersandroid.data.model.Student;
import com.example.seersandroid.data.source.Colleges.remote.CollegeApiService;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import io.reactivex.Single;

@AppScoped
public class RecommendationRemoteDataSource {

    @NonNull
    private RecommendationApiService mRecommendationApiService;

    @Inject
    public RecommendationRemoteDataSource(@NonNull RecommendationApiService recommendationApiService){
        mRecommendationApiService = recommendationApiService;
    }

    public Single<List<College>> getSchoolRecommendation(Student studnent){
        return mRecommendationApiService.getSchoolRecommendation(studnent);
    }

}
