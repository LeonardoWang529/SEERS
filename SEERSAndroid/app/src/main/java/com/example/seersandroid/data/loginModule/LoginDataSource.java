package com.example.seersandroid.data.loginModule;

import com.example.seersandroid.Classes.Operation;
import com.example.seersandroid.Classes.OperationListener;
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
public class LoginDataSource implements Operation {
    StudentDAO studentDAO;
    Retrofits retrofits;
    OperationListener mlistener;

    @Override
    public void setListerner(OperationListener operationListener) {
        mlistener = operationListener;
    }

    public LoginDataSource(){
        retrofits = Retrofits.getInstance();
        studentDAO = retrofits.retrofit.create(StudentDAO.class);
    }

    public void login(String username, String password) {

        Call<Student> call = studentDAO.login(username,password);

        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                if(!response.isSuccessful()){

                }
                Student s = response.body();
                mlistener.onSuccess(new Result.Success<>(s));
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                mlistener.onError(new Result.Error(new Exception(t.getMessage())));
            }
        });

    }

    public void logout() {
        // TODO: revoke authentication
    }

}
