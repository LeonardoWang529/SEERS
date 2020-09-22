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
    StudentDataSource mStudentsLocalDataSource;
    OnlineChecker mOnlineChecker;
    private Student student = null;

    @Inject
    public StudentRepository(@Remote StudentDataSource studentsRemoteDataSource,
                             @Local StudentDataSource studentsLocalDataSource,
                             OnlineChecker onlineChecker){
        mStudentsRemoteDataSource = studentsRemoteDataSource;
        mStudentsLocalDataSource = studentsLocalDataSource;
        mOnlineChecker = onlineChecker;
    }

    @NonNull
    @Override
    public Single<Student> getStudent(@NonNull String userName, @NonNull String password) {
        return mStudentsLocalDataSource.getStudent(userName,password)
                .flatMap(data -> {
/*                    if(mOnlineChecker.isOnline() && (data == null || isStale(data))){
                        return getFreshStudnet(userName,password);
                    }*/
                   return Single.just(data);
                }).map(data -> student = data);
    }

    public Student getStudent(){
        return student;
    }

    @Override
    public void deleteStudent() {

    }

    @Override
    public void saveStudent(@NonNull Student student) {
        //checkNotNull()
        mStudentsLocalDataSource.saveStudent(student);
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
