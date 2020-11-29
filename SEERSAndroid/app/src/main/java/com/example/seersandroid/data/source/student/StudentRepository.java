package com.example.seersandroid.data.source.student;

import com.example.seersandroid.Utilities.ConnectivityUtils.OnlineChecker;
import com.example.seersandroid.Utilities.scopes.AppScoped;
import com.example.seersandroid.data.model.Student;
import com.example.seersandroid.data.source.scopes.Local;
import com.example.seersandroid.data.source.scopes.Remote;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import io.reactivex.Single;

@AppScoped
public class StudentRepository implements StudentDataSource {

    StudentDataSource mStudentsRemoteDataSource;
    //StudentDataSource mStudentsLocalDataSource;
    OnlineChecker mOnlineChecker;
    private Student mStudent = null;

    @Inject
    public StudentRepository(@Remote StudentDataSource studentsRemoteDataSource,
                             OnlineChecker onlineChecker){
        mStudentsRemoteDataSource = studentsRemoteDataSource;
        mOnlineChecker = onlineChecker;
    }

    @NonNull
    @Override
    public Single<Student> getStudent(@NonNull String userName, @NonNull String password) {
        //return mStudentsRemoteDataSource.getStudent(userName,password).doOnSuccess(this::saveStudent);
        Student student = new Student();
        student.setUserId("13");
        student.setUserName("test2@test.com");
        student.setFirstName("Hey");
        student.setLastName("Zhang");
        student.setGpa(100);
        student.setSAT_math(100);
        student.setSat_reading(100);
        student.setSat_writing(100);
        student.setAct(100);
        student.setToken("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMyIsIlJvbGVzIjpbIlN0dWRlbnQiXSwiZXhwIjoxNjA2NjM3MDc0fQ.NcWbc5oUYlxwlQdIWQujzkTcLEGlMnPvoBl257EH_zc2m3ZtYCDKHFNQvcDy8nnmUjldKINW9K1CyOXxqqh89g");
        saveStudent(student);
        return Single.just(student);
    }

    public Student getCurrentStudent(){
        return mStudent;
    }

    @Override
    public void deleteStudent() {

    }

    @Override
    public void saveStudent(@NonNull Student student) {
        mStudent = student;
        //checkNotNull()
        //mStudentsLocalDataSource.saveStudent(student);
        //mStudentsRemoteDataSource.saveStudent(student);
    }

    /**
     * Helper methods, should be encapsulated
     */

    private boolean isStale(Student data) {
        // it is enough for 1 item to be stale
        return !data.isUpToDate();
    }

    /**
     * Contains data refreshing logic
     * Both sources are emptied, then new items are retrieved from querying the Remote Source
     * and finally, sources are replenished
     */
    private Single<Student> getFreshStudnet(@NonNull String userName, @NonNull String password) {
        deleteStudent();

        return mStudentsRemoteDataSource.getStudent(userName,password).
                doOnSuccess(this::saveStudent);
    }
}
