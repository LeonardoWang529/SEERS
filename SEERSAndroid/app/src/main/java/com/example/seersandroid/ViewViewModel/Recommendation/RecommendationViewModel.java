package com.example.seersandroid.ViewViewModel.Recommendation;

import com.example.seersandroid.ViewViewModel.Colleges.CollegeLists.CollegeListResult;
import com.example.seersandroid.data.source.Colleges.CollegeRepository;
import com.example.seersandroid.data.source.Recommendation.RecommendationRepository;
import com.example.seersandroid.data.source.student.StudentRepository;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RecommendationViewModel extends ViewModel {
    CollegeRepository mCollegeRepository;
    StudentRepository mStudentRepository;
    RecommendationRepository mRecommendationRepository;

    private MutableLiveData<RecommendationCollegeListResult> collegeListResult = new MutableLiveData<>();
    LiveData<RecommendationCollegeListResult> getRecommendationLiveData(){ return collegeListResult; }

    @Inject
    public RecommendationViewModel(CollegeRepository collegeListRepository,
                                   StudentRepository studentRepository,
                                   RecommendationRepository recommendationRepository){
        mCollegeRepository = collegeListRepository;
        mStudentRepository = studentRepository;
        mRecommendationRepository = recommendationRepository;
    }

    public void getSchoolRecommendation(){
        mRecommendationRepository.getSchoolRecommendation(mStudentRepository.getCurrentStudent().getToken(),mStudentRepository.getCurrentStudent().getUserId())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .subscribe(
                        success -> collegeListResult.setValue(new RecommendationCollegeListResult(success)),
                        error -> collegeListResult.setValue(new RecommendationCollegeListResult(error.getMessage()))
                );
    }

}
