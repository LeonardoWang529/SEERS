package com.example.seersandroid.data.signUpModule;

import com.example.seersandroid.data.Result;
import com.example.seersandroid.data.Retrofits;
import com.example.seersandroid.data.dao.StudentDAO;
import com.example.seersandroid.data.model.Student;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class SignUpDataSource{
    StudentDAO studentDAO;
    Retrofits retrofits;

    public SignUpDataSource(){
        retrofits = Retrofits.getInstance();
        studentDAO = retrofits.retrofit.create(StudentDAO.class);
    }

    public void signup(String username, String password) {

    }

    public void logout() {
        // TODO: revoke authentication
    }

}