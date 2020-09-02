package com.example.seersandroid.data.loginModule;

import com.example.seersandroid.data.Result;
import com.example.seersandroid.data.dao.StudentDAO;
import com.example.seersandroid.data.model.Student;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.annotation.Nullable;
import io.reactivex.Single;

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

public class LoginRepository{

    private static volatile LoginRepository instance;
    private final StudentDAO dataSource;

    // If user credentials will be cached in local storage, it is recommended it be encrypted
    // @see https://developer.android.com/training/articles/keystore
    private Student user = null;

    // private constructor : singleton access
    @Inject
    public LoginRepository(StudentDAO dataSource) {
        this.dataSource = dataSource;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public void logout() { user = null; }

    public Student getLoggedinUser(){
        if(isLoggedIn()){
            return user;
        }else{
            return null;
        }
    }

    public void setLoggedInUser(Student user) {
        this.user = user;
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    public Single<Student> getStudent(String username, String password){
        return dataSource.login(username,password);
    }
}
