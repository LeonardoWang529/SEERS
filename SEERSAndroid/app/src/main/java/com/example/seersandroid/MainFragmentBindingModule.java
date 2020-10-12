package com.example.seersandroid;

import com.example.seersandroid.ViewViewModel.Colleges.CollegeLists.CollegeListFragment;
import com.example.seersandroid.ViewViewModel.Colleges.CollegeMap.CollegeMapsFragment;
import com.example.seersandroid.ViewViewModel.Colleges.CollegesFragment;
import com.example.seersandroid.ViewViewModel.Login.LoginFragment;
import com.example.seersandroid.ViewViewModel.Login.SignUpFragment;
import com.example.seersandroid.ViewViewModel.Navigation.NavigationFragment;
import com.example.seersandroid.ViewViewModel.PersonalDashBoard.PassScoreFragment;
import com.example.seersandroid.ViewViewModel.PersonalDashBoard.PersonalDashBoardFragment;
import com.example.seersandroid.ViewViewModel.PersonalDashBoard.PiChartFragment;
import com.example.seersandroid.ViewViewModel.StudentID.StudentIdFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract LoginFragment provideLoginFragment();

    @ContributesAndroidInjector
    abstract SignUpFragment provideSignUpFragment();

    @ContributesAndroidInjector
    abstract NavigationFragment provideNavigationFragment();

    @ContributesAndroidInjector
    abstract PersonalDashBoardFragment providePersonalDashBoardFragment();

    @ContributesAndroidInjector
    abstract PassScoreFragment providePassScoreFragment();

    @ContributesAndroidInjector
    abstract PiChartFragment providePiChartFragment();

    @ContributesAndroidInjector
    abstract StudentIdFragment provideStudentIdFragment();

    @ContributesAndroidInjector
    abstract CollegesFragment provideCollegesFragment();

    @ContributesAndroidInjector
    abstract CollegeListFragment provideCollegeListFragment();

    @ContributesAndroidInjector
    abstract CollegeMapsFragment provideCollegeMapsFragment();
}
