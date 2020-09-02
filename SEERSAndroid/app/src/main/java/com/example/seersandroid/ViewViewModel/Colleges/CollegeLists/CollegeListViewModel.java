package com.example.seersandroid.ViewViewModel.Colleges.CollegeLists;

import com.example.seersandroid.data.Result;
import com.example.seersandroid.data.collegeModule.CollegeListRepository;
import com.example.seersandroid.data.model.College;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CollegeListViewModel extends ViewModel {

    private MutableLiveData<CollegeListResult> collegeListResult = new MutableLiveData<>();

    CollegeListRepository collegeListRepository;

    LiveData<CollegeListResult> getTwentyCollegeLiveData(){ return collegeListResult; }

    public CollegeListViewModel(){
        collegeListRepository = new CollegeListRepository();
        getTwentyCollegeData();
    }

    public void getTwentyCollegeData(){
        collegeListRepository.getTwentyCollegeListData("1");
    }


}
