package com.example.seersandroid.data.source.student.local;

import com.example.seersandroid.data.model.Student;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Single;

@Dao
public interface StudentDao {

    /**
     * Retrieve a Student by userName.
     *
     * @param userName the Student userName.
     * @return the Student with userName
     */
    @Query("SELECT * FROM student WHERE userName = :userName")
    Single<Student> getStudentByUserName(String userName);

    /**
     * Retrieve a Student by userName and password.
     *
     * @param userId the Student userId.
     * @return the Student with userName and password
     */
    @Query("SELECT * FROM student WHERE id = :userId")
    Single<Student> getStudentById(String userId);

    /**
     * Insert Student in the database. If the Student already exists, ignore the action.
     *
     * @param student to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStudent(Student student);
}
