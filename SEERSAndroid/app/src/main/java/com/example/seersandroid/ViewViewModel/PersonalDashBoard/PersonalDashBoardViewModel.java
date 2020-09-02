package com.example.seersandroid.ViewViewModel.PersonalDashBoard;

import com.example.seersandroid.data.loginModule.LoginRepository;
import com.example.seersandroid.data.model.Student;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PersonalDashBoardViewModel extends ViewModel {

    private MutableLiveData<Student> mStudent = new MutableLiveData<>();
    private final LoginRepository studentRepository;

    @Inject
    public PersonalDashBoardViewModel(LoginRepository studentRepository) {
        this.studentRepository = studentRepository;
        mStudent.setValue(studentRepository.getLoggedinUser());
    }

    public LiveData<Student> getStudent() {
        return mStudent;
    }
}