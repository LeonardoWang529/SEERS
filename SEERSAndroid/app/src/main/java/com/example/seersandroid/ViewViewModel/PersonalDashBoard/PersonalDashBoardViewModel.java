package com.example.seersandroid.ViewViewModel.PersonalDashBoard;

import com.example.seersandroid.data.loginModule.LoginDataSource;
import com.example.seersandroid.data.loginModule.LoginRepository;
import com.example.seersandroid.data.model.Student;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PersonalDashBoardViewModel extends ViewModel {

    private MutableLiveData<Student> mStudent;
    private LoginRepository studnetStatus;

    public PersonalDashBoardViewModel() {
        mStudent = new MutableLiveData<>();
        studnetStatus = LoginRepository.getInstance(new LoginDataSource());
        mStudent.setValue(studnetStatus.getLoggedinUser());
    }

    public LiveData<Student> getStudent() {
        return mStudent;
    }
}