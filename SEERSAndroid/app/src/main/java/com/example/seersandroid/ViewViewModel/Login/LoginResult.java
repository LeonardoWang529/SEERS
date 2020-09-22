package com.example.seersandroid.ViewViewModel.Login;

import com.example.seersandroid.data.model.Student;

import androidx.annotation.Nullable;

/**
 * Authentication result : success (user details) or error message.
 */
class LoginResult {
    @Nullable
    private Student success;
    @Nullable
    private Throwable error;

    LoginResult(@Nullable Throwable error) {
        this.error = error;
    }

    LoginResult(@Nullable Student success) {
        this.success = success;
    }

    @Nullable
    Student getSuccess() {
        return success;
    }

    @Nullable
    Throwable getError() {
        return error;
    }
}