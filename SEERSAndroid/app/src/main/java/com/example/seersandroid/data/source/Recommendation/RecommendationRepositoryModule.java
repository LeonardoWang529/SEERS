package com.example.seersandroid.data.source.Recommendation;

import com.example.seersandroid.Utilities.scopes.AppScoped;
import com.example.seersandroid.data.source.Colleges.remote.CollegeApiService;
import com.example.seersandroid.data.source.Colleges.remote.CollegeRemoteDataSource;
import com.example.seersandroid.data.source.Recommendation.remote.RecommendationApiService;
import com.example.seersandroid.data.source.Recommendation.remote.RecommendationRemoteDataSource;
import com.example.seersandroid.data.source.RemoteDataModule;
import com.example.seersandroid.data.source.scopes.Remote;

import dagger.Module;
import dagger.Provides;


@Module(includes = {RemoteDataModule.class})
public class RecommendationRepositoryModule {

    @Provides
    @Remote
    @AppScoped
    RecommendationRemoteDataSource provideRecommendationRemoteDataSource(RecommendationApiService recommendationApiService){
        return new RecommendationRemoteDataSource(recommendationApiService);
    }
}
