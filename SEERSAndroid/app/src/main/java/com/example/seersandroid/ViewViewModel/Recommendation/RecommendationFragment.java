package com.example.seersandroid.ViewViewModel.Recommendation;

import android.os.Bundle;
import android.view.View;

import com.example.seersandroid.R;
import com.example.seersandroid.ViewViewModel.Navigation.NavigationActivity;
import com.example.seersandroid.ViewViewModel.PersonalDashBoard.CurrentScoreFragment;
import com.example.seersandroid.ViewViewModel.PersonalDashBoard.PassScoreFragment;
import com.example.seersandroid.base.BaseActivity;
import com.example.seersandroid.base.BaseFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RecommendationFragment extends BaseFragment {


    @Override
    protected int layoutRes() {
        return R.layout.fragment_recommendation;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUniversityRecFragment();
        setMBTIFragment();
    }

    public void setUniversityRecFragment(){
        UniversityRecFragment universityRecFragment = new UniversityRecFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .add(R.id.recom_container,universityRecFragment)
                .commit();

    }

    public void setMBTIFragment(){
        MBTIFragment mbtiFragment = new MBTIFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .add(R.id.mbti_container,mbtiFragment)
                .commit();

    }
}
