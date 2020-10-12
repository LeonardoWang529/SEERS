package com.example.seersandroid.ViewViewModel.Colleges.CollegeLists;

import com.example.seersandroid.data.source.Colleges.CollegeRepository;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CollegeListViewModel extends ViewModel {

    private MutableLiveData<CollegeListResult> collegeListResult = new MutableLiveData<>();

    CollegeRepository mCollegeRepository;

    LiveData<CollegeListResult> getTwentyCollegeLiveData(){ return collegeListResult; }

    @Inject
    public CollegeListViewModel(CollegeRepository collegeListRepository){
        mCollegeRepository = collegeListRepository;
    }

    public void getCollectData(){
        mCollegeRepository.geColleges()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .subscribe(
                        success -> collegeListResult.setValue(new CollegeListResult(success)),
                        error -> collegeListResult.setValue(new CollegeListResult(error.getMessage()))
                );
    }


}
