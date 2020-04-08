package com.example.seersandroid.data.collegeModule;

import com.example.seersandroid.Classes.Operation;
import com.example.seersandroid.Classes.OperationListener;
import com.example.seersandroid.data.Result;
import com.example.seersandroid.data.Retrofits;
import com.example.seersandroid.data.dao.CollegeDAO;
import com.example.seersandroid.data.model.College;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CollegeListRepository implements Operation{
    private static volatile CollegeListRepository instance;
    OperationListener mListener;
    CollegeDAO collegeDAO;
    Retrofits retrofits;

    @Override
    public void setListerner(OperationListener operationListener) {
        this.mListener = operationListener;
    }

    public static CollegeListRepository getInstance() {
        if (instance == null) {
            instance = new CollegeListRepository();
        }
        return instance;
    }

    public CollegeListRepository(){
        retrofits = Retrofits.getInstance();
        collegeDAO = retrofits.retrofit.create(CollegeDAO.class);
    }

    public void getTwentyCollegeListData(String order){
        Call<List<College>> call = collegeDAO.getTwentyCollegeData();

        call.enqueue(new Callback<List<College>>() {
            @Override
            public void onResponse(Call<List<College>> call, Response<List<College>> response) {
                if(!response.isSuccessful()){

                }
                List<College> l = response.body();
                mListener.onSuccess(new Result.Success<>(l));
            }

            @Override
            public void onFailure(Call<List<College>> call, Throwable t) {
                mListener.onError(new Result.Error(new Exception(t.getMessage())));
            }
        });
    }

    public void getCollegeListData(String order){
        Call<List<College>> call = collegeDAO.getCollegeData();

        call.enqueue(new Callback<List<College>>() {
            @Override
            public void onResponse(Call<List<College>> call, Response<List<College>> response) {
                if(!response.isSuccessful()){

                }
                List<College> l = response.body();
                mListener.onSuccess(new Result.Success<>(l));
            }

            @Override
            public void onFailure(Call<List<College>> call, Throwable t) {
                mListener.onError(new Result.Error(new Exception(t.getMessage())));
            }
        });
    }

}
