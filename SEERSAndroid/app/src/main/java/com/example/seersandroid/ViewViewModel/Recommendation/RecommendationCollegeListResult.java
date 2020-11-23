package com.example.seersandroid.ViewViewModel.Recommendation;

import com.example.seersandroid.data.model.College;

import java.util.List;

import androidx.annotation.Nullable;

public class RecommendationCollegeListResult {

    @Nullable
    private List<College> success;
    @Nullable
    private String error;

    RecommendationCollegeListResult(@Nullable String error) {
        this.error = error;
    }

    RecommendationCollegeListResult(@Nullable List<College> success) {
        this.success = success;
    }

    @Nullable
    List<College> getSuccess() {
        return success;
    }

    @Nullable
    String getError() {
        return error;
    }
}
