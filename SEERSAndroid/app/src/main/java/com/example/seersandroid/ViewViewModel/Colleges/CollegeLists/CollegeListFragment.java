package com.example.seersandroid.ViewViewModel.Colleges.CollegeLists;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.seersandroid.Classes.OnItemClickListener;
import com.example.seersandroid.R;
import com.example.seersandroid.ViewViewModel.Colleges.CollegeItemFragment;
import com.example.seersandroid.data.model.College;
import com.example.seersandroid.databinding.FragmentCollegelistBinding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CollegeListFragment extends Fragment{

    private FragmentCollegelistBinding binding;
    RecyclerView collegeRecyclerView;
    CollegeListViewModel collegeListViewModel;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        binding =FragmentCollegelistBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();

        collegeRecyclerView = binding.collegeRecycleView;
        collegeRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        final CollegeListAdapter collegeListAdapter = new CollegeListAdapter();
        collegeRecyclerView.setAdapter(collegeListAdapter);
        collegeListAdapter.setListerner(itemClickListener);

        collegeListViewModel = ViewModelProviders.of(this).get(CollegeListViewModel.class);
        collegeListViewModel.getTwentyCollegeData();
        collegeListViewModel.getTwentyCollegeLiveData().observe(this.getActivity(), new Observer<CollegeListResult>() {
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
                getActivity().finish();
            }
        });
        return v;
    }

    private  OnItemClickListener itemClickListener = new OnItemClickListener() {
        @Override
        public void onClick(Object o) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("SelectCollege", (College)o);

            CollegeItemFragment collegeItemFragment = new CollegeItemFragment();
            collegeItemFragment.setArguments(bundle);
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentContainer, collegeItemFragment)
                    .commit();
        }
    };
}
