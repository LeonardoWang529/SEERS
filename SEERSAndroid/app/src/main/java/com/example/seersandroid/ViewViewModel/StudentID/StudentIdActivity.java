package com.example.seersandroid.ViewViewModel.StudentID;

import android.os.Bundle;
import android.view.View;

import com.example.seersandroid.R;
import com.example.seersandroid.databinding.ActivityStudentidBinding;
import com.example.seersandroid.databinding.FragmentStudentidBinding;

import androidx.appcompat.app.AppCompatActivity;

public class StudentIdActivity extends AppCompatActivity {

    private ActivityStudentidBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityStudentidBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();

        setContentView(v);

    }
}
