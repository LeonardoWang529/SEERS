package com.example.seersandroid.ViewViewModel.SignUp;

import com.example.seersandroid.data.model.Student;

/**
 * Class exposing authenticated user details to the UI.
 */
class SignedUpInUserView {
    private Student student;
    //... other data fields that may be accessible to the UI

    SignedUpInUserView(Student student) {
        this.student = student;
    }

    String getDisplayName() {
        return student.getName();
    }
}
