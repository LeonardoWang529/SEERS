package com.example.seersandroid.data.source.Recommendation.remote;

import com.example.seersandroid.data.model.College;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface RecommendationApiService {

    @Headers("Content-Type: application/json")
    @HTTP(method = "GET", path = "/recommendation/school", hasBody = true)
    Single<List<College>> getSchoolRecommendation(@Header("X-Auth-Token") String token, @Body String userId);

    @Headers("Content-Type: application/json")
    @GET("/recommendation/major")
    Single<List<College>> getMajorRecommendation(@Header("X-Auth-Token") String token);

    @Headers("Content-Type: application/json")
    @GET("/recommendation/Data")
    Single<List<College>> getDataRecommendation(@Header("X-Auth-Token") String token);
}
