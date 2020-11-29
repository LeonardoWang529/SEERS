package com.example.seersandroid.ViewViewModel.Recommendation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.seersandroid.Classes.OnItemClickListener;
import com.example.seersandroid.R;
import com.example.seersandroid.Utilities.ViewModelFactory;
import com.example.seersandroid.ViewViewModel.Colleges.CollegeDetailActivity;
import com.example.seersandroid.ViewViewModel.Colleges.CollegeLists.CollegeListAdapter;
import com.example.seersandroid.ViewViewModel.Colleges.CollegeLists.CollegeListResult;
import com.example.seersandroid.ViewViewModel.Colleges.CollegeLists.CollegeListViewModel;
import com.example.seersandroid.ViewViewModel.Login.StudentViewModel;
import com.example.seersandroid.base.BaseFragment;
import com.example.seersandroid.data.model.College;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class UniversityRecFragment extends BaseFragment implements OnItemClickListener {

    @BindView(R.id.collegeRecycleView)
    RecyclerView collegeRecycleView;

    @Inject
    ViewModelFactory viewModelFactory;
    RecommendationViewModel mViewModel;
    CollegeListAdapter collegeListAdapter;

    @Override
    protected int layoutRes() {
        return R.layout.fragment_university_recommendation;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        collegeRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        collegeListAdapter = new CollegeListAdapter();
        collegeRecycleView.setAdapter(collegeListAdapter);
        collegeListAdapter.setListerner(this);
        mViewModel = new ViewModelProvider(this,viewModelFactory).get(RecommendationViewModel.class);

        mViewModel.getRecommendationLiveData().observe(getActivity(), new Observer<RecommendationCollegeListResult>() {
            @Override
            public void onChanged(RecommendationCollegeListResult collegeListResult) {
                if(collegeListResult == null) return;
                if (collegeListResult.getError() != null) {
                    //showLoginFailed(collegeListResult.getError());
                }
                if (collegeListResult.getSuccess() != null) {
                    //updateUiWithUser(collegeListResult.getSuccess());
                    collegeListAdapter.clearCollegeList();
                    collegeListAdapter.setCollegeList(collegeListResult.getSuccess());
                }
                getActivity().setResult(Activity.RESULT_OK);

            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        mViewModel.getSchoolRecommendation();
    }

    @Override
    public void onClick(Object o) {
        Intent i = new Intent(getActivity(), CollegeDetailActivity.class);
        i.putExtra("COLLEGE_ID",((College)o).getCollegeId());
        startActivity(i);
    }
}
