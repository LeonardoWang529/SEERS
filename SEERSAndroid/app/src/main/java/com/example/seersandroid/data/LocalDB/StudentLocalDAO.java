package com.example.seersandroid.data.LocalDB;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface StudentLocalDAO {

    @Query("SELECT * FROM student_table")
    List<StudentLocal> getAll();

    @Query("SELECT * FROM student_table WHERE userId IN (:userIds)")
    List<StudentLocal> getUserProfiles(int[] userIds);

    @Query("SELECT * FROM student_table WHERE userId = :userId")
    StudentLocal getUserProfile(int userId);

    @Query("SELECT * FROM student_table WHERE userName = :username and password = :password")
    StudentLocal getUserProfile(String username, String password);

    @Insert
    public void insertUser(StudentLocal user);

    @Insert
    void insertAll(StudentLocal... users);

    @Delete
    void deleteUser(StudentLocal user);
}
