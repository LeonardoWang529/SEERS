package com.example.seersandroid.Utilities.di.module;

import com.example.seersandroid.Utilities.ViewModelFactory;
import com.example.seersandroid.Utilities.di.util.ViewModelKey;
import com.example.seersandroid.Utilities.scopes.AppScoped;
import com.example.seersandroid.ViewViewModel.Colleges.CollegeLists.CollegeListViewModel;
import com.example.seersandroid.ViewViewModel.Login.StudentViewModel;
import com.example.seersandroid.ViewViewModel.PersonalDashBoard.PersonalDashBoardViewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(StudentViewModel.class)
    abstract ViewModel bindStudentViewModel(StudentViewModel studentViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PersonalDashBoardViewModel.class)
    abstract ViewModel bindPersonalDashBoardViewModel(PersonalDashBoardViewModel personalDashBoardViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CollegeListViewModel.class)
    abstract ViewModel bindCollegeListViewModel(CollegeListViewModel collegeListViewModel);

    @Binds
    @AppScoped
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
