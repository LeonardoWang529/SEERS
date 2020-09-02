package com.example.seersandroid.data.collegeModule;

import com.example.seersandroid.data.Result;
import com.example.seersandroid.data.Retrofits;
import com.example.seersandroid.data.dao.CollegeDAO;
import com.example.seersandroid.data.model.College;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CollegeListRepository {
    private static volatile CollegeListRepository instance;
    CollegeDAO collegeDAO;
    Retrofits retrofits;

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

            }

            @Override
            public void onFailure(Call<List<College>> call, Throwable t) {

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
            }

            @Override
            public void onFailure(Call<List<College>> call, Throwable t) {
            }
        });
    }

}
