package com.example.seersandroid.ViewViewModel.Navigation;

import com.example.seersandroid.Utilities.providers.BaseResourceProvider;
import com.example.seersandroid.Utilities.providers.ResourceProvider;
import com.example.seersandroid.Utilities.scopes.ActivityScoped;
import com.example.seersandroid.Utilities.scopes.FragmentScoped;
import com.example.seersandroid.ViewViewModel.Colleges.CollegeLists.CollegeListFragment;
import com.example.seersandroid.ViewViewModel.Colleges.CollegeMap.CollegeMapsFragment;
import com.example.seersandroid.ViewViewModel.Colleges.CollegesFragment;
import com.example.seersandroid.ViewViewModel.PersonalDashBoard.PassScoreFragment;
import com.example.seersandroid.ViewViewModel.PersonalDashBoard.PersonalDashBoardFragment;
import com.example.seersandroid.ViewViewModel.PersonalDashBoard.PiChartFragment;
import com.example.seersandroid.ViewViewModel.Recommendation.RecommendationFragment;
import com.example.seersandroid.ViewViewModel.StudentID.StudentIdFragment;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module (includes = {NavigationBindingModule.navigationAbstractModule.class})
public class NavigationBindingModule {

    @ActivityScoped
    @Provides
    BaseResourceProvider provideResourceProvider(NavigationActivity context) {
        return new ResourceProvider(context);
    }

    @Module
    public interface navigationAbstractModule {
        @FragmentScoped
        @ContributesAndroidInjector
        abstract PersonalDashBoardFragment providePersonalDashBoardFragment();
        @FragmentScoped
        @ContributesAndroidInjector
        abstract PassScoreFragment providePassScoreFragment();
        @FragmentScoped
        @ContributesAndroidInjector
        abstract PiChartFragment providePiChartFragment();
        @FragmentScoped
        @ContributesAndroidInjector
        abstract StudentIdFragment provideStudentIdFragment();
        @FragmentScoped
        @ContributesAndroidInjector
        abstract CollegesFragment provideCollegesFragment();
        @FragmentScoped
        @ContributesAndroidInjector
        abstract CollegeListFragment provideCollegeListFragment();
        @FragmentScoped
        @ContributesAndroidInjector
        abstract CollegeMapsFragment provideCollegeMapsFragment();

        @FragmentScoped
        @ContributesAndroidInjector
        abstract RecommendationFragment provideRecommendationFragment();
    }

}
