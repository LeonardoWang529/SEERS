package com.example.seersandroid.ViewViewModel.PersonalDashBoard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PersonalDashBoardViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PersonalDashBoardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}