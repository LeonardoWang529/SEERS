package com.example.seersandroid.data.source.student.local;

import com.example.seersandroid.Utilities.schedulers.BaseSchedulerProvider;
import com.example.seersandroid.Utilities.scopes.AppScoped;
import com.example.seersandroid.data.model.Student;
import com.example.seersandroid.data.source.student.StudentDataSource;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import io.reactivex.Completable;
import io.reactivex.Single;

@AppScoped
public class StudentLocalDataSource implements StudentDataSource {

    private final StudentDao mStudentDao;

    private BaseSchedulerProvider mSchedulerProvider;

    @Inject
    public StudentLocalDataSource(@NonNull StudentDao studentDao,
                                 @NonNull BaseSchedulerProvider schedulerProvider) {
/*        checkNotNull(schedulerProvider, "scheduleProvider cannot be null");
        checkNotNull(quakesDao, "quakesDao cannot be null");*/

        mStudentDao = studentDao;
        mSchedulerProvider = schedulerProvider;
    }

    @NonNull
    @Override
    public Single<Student> getStudent(@NonNull String userName, @NonNull String password) {
        return mStudentDao.getStudentById("0");
    }

    @Override
    public void deleteStudent() {

    }

    @Override
    public void saveStudent(@NonNull Student student) {
        Completable.fromRunnable(() -> mStudentDao.insertStudent(student))
                .subscribeOn(mSchedulerProvider.io()).subscribe();
    }
}
