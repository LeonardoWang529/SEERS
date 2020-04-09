package com.example.seersandroid.ViewViewModel.Colleges.CollegeLists;

import com.example.seersandroid.Classes.OperationListener;
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
        collegeListRepository.setListerner(getCollegeDataListener);
        collegeListRepository.getTwentyCollegeListData("1");
    }

    OperationListener getCollegeDataListener = new OperationListener() {
        @Override
        public void onSuccess(Result result) {
            collegeListResult.setValue(new CollegeListResult(((Result.Success<List<College>>) result).getData()));
        }

        @Override
        public void onError(Result result) {

        }

        @Override
        public void onPreExecution() {

        }

        @Override
        public void onPostExecution() {

        }

        @Override
        public void onOperationProgressUpdate(String... updateParams) {

        }
    };

}
