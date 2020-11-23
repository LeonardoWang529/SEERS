package com.example.seersandroid.ViewViewModel.PersonalDashBoard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.seersandroid.R;
import com.example.seersandroid.ViewViewModel.Recommendation.UniversityRecFragment;
import com.example.seersandroid.base.BaseFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CurrentScoreFragment extends BaseFragment {


    @Override
    protected int layoutRes() {
        return R.layout.fragment_current_score;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setPiChartFragment();
    }

    public void setPiChartFragment(){
        PiChartFragment piChartFragment = new PiChartFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .add(R.id.piCharFragmentContainer,piChartFragment)
                .commit();

    }
}
