package com.example.seersandroid.ViewViewModel.Questionnairs;

import com.example.seersandroid.data.model.Question;

import java.util.List;

import androidx.annotation.Nullable;

public class QuestionListResult {
    @Nullable
    private List<Question> success;
    @Nullable
    private Integer error;

    QuestionListResult(@Nullable Integer err) {this.error = error;}
    QuestionListResult(@Nullable List<Question> success){
        this.success = success;
    }

    @Nullable
    List<Question> getSuccess() {
        return success;
    }

    @Nullable
    Integer getError() {
        return error;
    }

}
