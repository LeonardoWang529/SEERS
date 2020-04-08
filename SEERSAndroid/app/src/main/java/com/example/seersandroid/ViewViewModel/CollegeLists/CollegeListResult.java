package com.example.seersandroid.ViewViewModel.CollegeLists;

import com.example.seersandroid.data.model.College;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class CollegeListResult {

    @Nullable
    private List<College> success;
    @Nullable
    private Integer error;

    CollegeListResult(@Nullable Integer error) {
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
    Integer getError() {
        return error;
    }
}
