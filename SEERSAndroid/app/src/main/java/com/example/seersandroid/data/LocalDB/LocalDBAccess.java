package com.example.seersandroid.data.LocalDB;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {StudentLocal.class}, version = 1)
public abstract class LocalDBAccess extends RoomDatabase {

    private static volatile LocalDBAccess INSTANCE;

    public static LocalDBAccess getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (LocalDBAccess.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            LocalDBAccess.class, "SEERLocalDB")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };


    public abstract StudentLocalDAO studentLocalDAO();

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final StudentLocalDAO mDao;

        PopulateDbAsync(LocalDBAccess db) {
            mDao = db.studentLocalDAO();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            StudentLocal s = new StudentLocal();
            s.setUserName("leo9081");
            s.setPassword("123456");
            s.setName("Yi_Wang");
            s.setGender("male");
            s.setSAT_math("300");
            s.setSAT_verbal("300");
            s.setExpense_limit("10000000");

            mDao.insertUser(s);
            List<StudentLocal> studentLocal =  mDao.getAll();
            return null;
        }
    }

}
