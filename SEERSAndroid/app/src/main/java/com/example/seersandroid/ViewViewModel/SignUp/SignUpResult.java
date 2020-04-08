package com.example.seersandroid.ViewViewModel.SignUp;

import androidx.annotation.Nullable;

/**
 * Authentication result : success (user details) or error message.
 */
class SignUpResult {
    @Nullable
    private SignedUpInUserView success;
    @Nullable
    private Integer error;

    SignUpResult(@Nullable Integer error) {
        this.error = error;
    }

    SignUpResult(@Nullable SignedUpInUserView success) {
        this.success = success;
    }

    @Nullable
    SignedUpInUserView getSuccess() {
        return success;
    }

    @Nullable
    Integer getError() {
        return error;
    }
}
