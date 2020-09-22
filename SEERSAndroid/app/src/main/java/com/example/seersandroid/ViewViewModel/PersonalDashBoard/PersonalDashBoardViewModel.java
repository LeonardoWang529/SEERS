package com.example.seersandroid.ViewViewModel.PersonalDashBoard;

import com.example.seersandroid.Utilities.scopes.AppScoped;
import com.example.seersandroid.data.model.Student;
import com.example.seersandroid.data.source.student.StudentRepository;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

@AppScoped
public class PersonalDashBoardViewModel extends ViewModel {

    @NonNull private final StudentRepository mRepository;
    private MutableLiveData<Student> studentMutableLiveData = new MutableLiveData<>();

    @Inject
    public PersonalDashBoardViewModel(@NonNull StudentRepository studentRepository) {
        mRepository = studentRepository;
        studentMutableLiveData.setValue(mRepository.getStudent());
    }

    public LiveData<Student> getStudent() {
        return studentMutableLiveData;
    }
}