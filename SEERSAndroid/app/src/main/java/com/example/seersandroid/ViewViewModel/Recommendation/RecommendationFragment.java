package com.example.seersandroid.ViewViewModel.Recommendation;

import android.os.Bundle;
import android.view.View;

import com.example.seersandroid.R;
import com.example.seersandroid.ViewViewModel.Navigation.NavigationActivity;
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

        //((BaseActivity)getActivity()).addFragmentToActivity(MBTIFragment.class, R.id.mbti_container,"mbti");
        //((BaseActivity)getActivity()).addFragmentToActivity(UniversityRecFragment.class, R.id.recom_container,"mbti");
    }
}
