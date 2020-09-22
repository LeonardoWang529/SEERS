package com.example.seersandroid.data.source;

import android.app.Application;
import android.os.AsyncTask;

import com.example.seersandroid.Utilities.scopes.AppScoped;
import com.example.seersandroid.data.source.student.local.StudentDao;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import dagger.Module;
import dagger.Provides;

import static com.example.seersandroid.Utilities.Constants.SEERS_ROOM_DB_STRING;

@Module
public class LocalDataModule {
    @AppScoped
    @Provides
    LocalDatabase provideDb(Application context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                LocalDatabase.class, SEERS_ROOM_DB_STRING)
                .build();
    }

    @AppScoped
    @Provides
    StudentDao provideStudentsDao(LocalDatabase db) {
        return db.studentsDao();
    }
}
