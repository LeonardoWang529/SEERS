package com.example.seersandroid.ViewViewModel.Questionnairs;

import android.os.Bundle;

import com.example.seersandroid.databinding.FragmentQuestionnairsBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class QuestionnairsFragment extends Fragment {

    private FragmentQuestionnairsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentQuestionnairsBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();

        QuestionSectionsPagerAdapter questionSectionsPagerAdapter = new QuestionSectionsPagerAdapter(this.getContext(), getActivity().getSupportFragmentManager());
        binding.viewPager.setAdapter(questionSectionsPagerAdapter);
        binding.tabs.setupWithViewPager(binding.viewPager);

        return v;
    }
}