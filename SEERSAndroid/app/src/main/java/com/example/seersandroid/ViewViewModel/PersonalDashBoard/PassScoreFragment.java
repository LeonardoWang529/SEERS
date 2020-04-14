package com.example.seersandroid.ViewViewModel.PersonalDashBoard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.seersandroid.databinding.FragmentPassScoreBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PassScoreFragment extends Fragment {

    private FragmentPassScoreBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentPassScoreBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();

        return v;
    }
}
