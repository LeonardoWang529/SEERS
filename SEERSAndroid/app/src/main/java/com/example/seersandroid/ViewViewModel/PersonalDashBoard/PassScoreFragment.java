package com.example.seersandroid.ViewViewModel.PersonalDashBoard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.seersandroid.R;
import com.example.seersandroid.Utilities.ViewModelFactory;
import com.example.seersandroid.base.BaseFragment;
import com.example.seersandroid.databinding.FragmentPassScoreBinding;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class PassScoreFragment extends BaseFragment {

    @Inject
    ViewModelFactory viewModelFactory;
    private PersonalDashBoardViewModel personalDashBoardViewModel;

    @Override
    protected int layoutRes() { return R.layout.fragment_pass_score; }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        personalDashBoardViewModel = new ViewModelProvider(this, viewModelFactory)
                .get(PersonalDashBoardViewModel.class);
    }
}
