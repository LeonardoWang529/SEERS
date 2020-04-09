package com.example.seersandroid.ViewViewModel.Colleges;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.seersandroid.data.model.College;
import com.example.seersandroid.databinding.FragmentCollegeItemBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CollegeItemFragment extends Fragment {

    private FragmentCollegeItemBinding binding;
    private College college;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentCollegeItemBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            college = bundle.getParcelable("SelectCollege");
            popSchoolData();
        }

        return v;
    }

    private void popSchoolData() {



    }


}
