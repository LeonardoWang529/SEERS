package com.example.seersandroid.data.loginModule;

import com.example.seersandroid.Classes.OperationListener;
import com.example.seersandroid.data.Result;
import com.example.seersandroid.data.model.Student;

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
public class LoginRepository{

    private static volatile LoginRepository instance;
    private OperationListener mlistener;
    private LoginDataSource dataSource;

    // If user credentials will be cached in local storage, it is recommended it be encrypted
    // @see https://developer.android.com/training/articles/keystore
    private Student user = null;

    // private constructor : singleton access
    private LoginRepository(LoginDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public LoginRepository setOperationListener(OperationListener mlistener){
        this.mlistener = mlistener;
        return instance;
    }

    public static LoginRepository getInstance(LoginDataSource dataSource) {
        if (instance == null) {
            instance = new LoginRepository(dataSource);
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

    private void setLoggedInUser(Student user) {
        this.user = user;
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    public void login(String username, String password) {
        // handle login
        dataSource.setListerner(mlistener);
        dataSource.login(username, password);
    }

    public void setResult(Result result){
        if (result instanceof Result.Success) {
            setLoggedInUser(((Result.Success<Student>) result).getData());
        }
    }

}
