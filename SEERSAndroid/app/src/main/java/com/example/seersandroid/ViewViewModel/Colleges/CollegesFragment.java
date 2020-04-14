package com.example.seersandroid.ViewViewModel.Colleges;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.seersandroid.databinding.FragmentCollegesBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CollegesFragment extends Fragment {

    private FragmentCollegesBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentCollegesBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        CollegeSectionsPagerAdapter sectionsPagerAdapter = new CollegeSectionsPagerAdapter(this.getContext(),
                getActivity().getSupportFragmentManager());
        binding.viewPager.setAdapter(sectionsPagerAdapter);
        binding.tabs.setupWithViewPager(binding.viewPager);
        return view;
    }
}