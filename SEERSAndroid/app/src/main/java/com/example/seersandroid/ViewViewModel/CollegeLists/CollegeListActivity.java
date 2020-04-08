package com.example.seersandroid.ViewViewModel.CollegeLists;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.ViewOutlineProvider;

import com.example.seersandroid.data.model.College;
import com.example.seersandroid.databinding.ActivityCollegelistBinding;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CollegeListActivity extends AppCompatActivity {

    private ActivityCollegelistBinding binding;
    RecyclerView collegeRecyclerView;
    CollegeListViewModel collegeListViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        binding =ActivityCollegelistBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);

        collegeRecyclerView = binding.collegeRecycleView;
        collegeRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        final CollegeListAdapter collegeListAdapter = new CollegeListAdapter();
        collegeRecyclerView.setAdapter(collegeListAdapter);

        collegeListViewModel = ViewModelProviders.of(this).get(CollegeListViewModel.class);
        collegeListViewModel.getTwentyCollegeData();
        collegeListViewModel.getTwentyCollegeLiveData().observe(this, new Observer<CollegeListResult>() {
            @Override
            public void onChanged(CollegeListResult collegeListResult) {
                if(collegeListResult == null) return;
                if (collegeListResult.getError() != null) {
                    //showLoginFailed(collegeListResult.getError());
                }
                if (collegeListResult.getSuccess() != null) {
                    //updateUiWithUser(collegeListResult.getSuccess());
                    collegeListAdapter.setCollegeList(collegeListResult.getSuccess());
                }
                setResult(Activity.RESULT_OK);

                //Complete and destroy login activity once successful
                finish();
            }
        });

    }
}
