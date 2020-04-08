package com.example.seersandroid.ViewViewModel.Login;

import com.example.seersandroid.data.model.Student;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {
    private Student student;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(Student student) {
        this.student = student;
    }

    String getDisplayName() {
        return student.getName();
    }
}
