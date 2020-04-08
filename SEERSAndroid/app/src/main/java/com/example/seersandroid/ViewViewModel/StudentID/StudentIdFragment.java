package com.example.seersandroid.ViewViewModel.StudentID;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.seersandroid.databinding.FragmentStudentidBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StudentIdFragment extends Fragment {

    private FragmentStudentidBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentStudentidBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        return v;
    }


}
