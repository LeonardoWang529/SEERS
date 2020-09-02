package com.example.seersandroid.data.signUpModule;


import com.example.seersandroid.data.Result;
import com.example.seersandroid.data.model.Student;

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
public class SignUpRepository {

    private static volatile SignUpRepository instance;
    private SignUpDataSource dataSource;

    // If user credentials will be cached in local storage, it is recommended it be encrypted
    // @see https://developer.android.com/training/articles/keystore
    private Student user = null;

    // private constructor : singleton access
    private SignUpRepository(SignUpDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static SignUpRepository getInstance(SignUpDataSource dataSource) {
        if (instance == null) {
            instance = new SignUpRepository(dataSource);
        }
        return instance;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public void logout() {
        user = null;
        dataSource.logout();
    }

    private void setSignUpUser(Student user) {
        this.user = user;
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    public void signup(String username, String password) {
        // handle login
        dataSource.signup(username, password);
    }

    public void setResult(Result result){
        if (result instanceof Result.Success) {
            setSignUpUser(((Result.Success<Student>) result).getData());
        }
    }
}
