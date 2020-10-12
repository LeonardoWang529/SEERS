package com.example.seersandroid.ViewViewModel.Colleges.CollegeLists;

import com.example.seersandroid.data.model.College;

import java.util.List;

import androidx.annotation.Nullable;

public class CollegeListResult {

    @Nullable
    private List<College> success;
    @Nullable
    private String error;

    CollegeListResult(@Nullable String error) {
        this.error = error;
    }

    CollegeListResult(@Nullable List<College> success) {
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
