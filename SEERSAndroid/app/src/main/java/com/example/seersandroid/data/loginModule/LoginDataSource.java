package com.example.seersandroid.data.loginModule;

import android.app.Application;
import android.os.AsyncTask;

import com.example.seersandroid.Classes.Operation;
import com.example.seersandroid.Classes.OperationListener;
import com.example.seersandroid.data.LocalDB.LocalDBAccess;
import com.example.seersandroid.data.LocalDB.StudentLocal;
import com.example.seersandroid.data.LocalDB.StudentLocalDAO;
import com.example.seersandroid.data.Result;
import com.example.seersandroid.data.Retrofits;
import com.example.seersandroid.data.dao.StudentDAO;
import com.example.seersandroid.data.model.Student;

import java.io.IOException;
import java.net.URL;

import okhttp3.HttpUrl;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource implements Operation {
    StudentDAO studentDAO;
    StudentLocalDAO studentLocalDAO;
    Retrofits retrofits;
    static OperationListener mlistener;

    @Override
    public void setListerner(OperationListener operationListener) {
        mlistener = operationListener;
    }

    public LoginDataSource(Application mApplication){
        LocalDBAccess localDBAccess = LocalDBAccess.getDatabase(mApplication);
        studentLocalDAO = localDBAccess.studentLocalDAO();
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

    public void loginlocal(String username, String password) {
        new getAsyncTask(studentLocalDAO,username,password).execute();
    }

    private static class getAsyncTask extends AsyncTask<Void, Void, Void> {

        private StudentLocalDAO mAsyncTaskDao;
        private String mUsername;
        private String mPassword;
        private StudentLocal mStudentLocal;

        getAsyncTask( StudentLocalDAO dao, String username, String password) {
            mAsyncTaskDao = dao;
            mUsername = username;
            mPassword = password;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                mStudentLocal = mAsyncTaskDao.getUserProfile( mUsername,  mPassword);
            } catch (Exception e) {
                mlistener.onError(new Result.Error(new IOException("Error signup", e)));
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            //Testing code only:
            Student s = new Student();
            s.setUserName("leo9081");
            s.setPassword("123456");
            s.setName("Yi_Wang");
            s.setGender("male");
            s.setSAT_math("300");
            s.setSAT_verbal("300");
            s.setExpense_limit("10000000");


            if(mStudentLocal==null){
                mlistener.onError(new Result.Error(new Exception("Error LogIn")));
            }else{
                mlistener.onSuccess(new Result.Success<>(s));
            }
        }
    }


    public void logout() {
        // TODO: revoke authentication
    }

}
