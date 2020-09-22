package com.example.seersandroid.data.source;

import com.example.seersandroid.data.model.Student;
import com.example.seersandroid.data.source.student.local.StudentDao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class LocalDatabase extends RoomDatabase {
    public abstract StudentDao studentsDao();
}
