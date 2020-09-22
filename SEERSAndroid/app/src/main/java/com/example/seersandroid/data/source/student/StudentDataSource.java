package com.example.seersandroid.data.source.student;

import com.example.seersandroid.data.model.Student;

import androidx.annotation.NonNull;
import io.reactivex.Single;

public interface StudentDataSource {

    @NonNull
    Single<Student> getStudent(@NonNull String userName, @NonNull String password);

    void deleteStudent();

    void saveStudent(@NonNull Student student);
}
