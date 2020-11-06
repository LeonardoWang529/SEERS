package com.example.seersandroid.ViewViewModel.Colleges.CollegeLists;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.seersandroid.Classes.OnItemClickListener;
import com.example.seersandroid.MainActivity;
import com.example.seersandroid.R;
import com.example.seersandroid.Utilities.ViewModelFactory;
import com.example.seersandroid.ViewViewModel.Colleges.CollegeItemFragment;
import com.example.seersandroid.ViewViewModel.StudentID.StudentIdFragment;
import com.example.seersandroid.base.BaseFragment;
import com.example.seersandroid.data.model.College;
import com.example.seersandroid.databinding.FragmentCollegelistBinding;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class CollegeListFragment extends BaseFragment implements OnItemClickListener{


    @BindView(R.id.collegeRecycleView)
    RecyclerView collegeRecycleView;

    @Inject
    ViewModelFactory viewModelFactory;
    CollegeListViewModel collegeListViewModel;
    CollegeListAdapter collegeListAdapter;

    @Override
    protected int layoutRes() {
        return R.layout.fragment_collegelist;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        collegeRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        collegeListAdapter = new CollegeListAdapter();
        collegeRecycleView.setAdapter(collegeListAdapter);
        collegeListAdapter.setListerner(this);
        collegeListViewModel = viewModelFactory.create(CollegeListViewModel.class);
        collegeListViewModel.getCollectData();
        collegeListViewModel.getTwentyCollegeLiveData().observe(getActivity(), new Observer<CollegeListResult>() {
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
                getActivity().setResult(Activity.RESULT_OK);

                //Complete and destroy login activity once successful
                //getActivity().finish();
            }
        });

    }

    @Override
    public void onClick(Object o) {

    }
}
