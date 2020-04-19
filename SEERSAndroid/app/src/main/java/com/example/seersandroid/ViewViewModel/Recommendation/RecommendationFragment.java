package com.example.seersandroid.ViewViewModel.Recommendation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.seersandroid.databinding.FragmentRecommendationBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RecommendationFragment extends Fragment {

    FragmentRecommendationBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentRecommendationBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();

        return v;
    }
}
