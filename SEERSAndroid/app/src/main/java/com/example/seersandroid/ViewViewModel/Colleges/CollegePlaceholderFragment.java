package com.example.seersandroid.ViewViewModel.Colleges;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.seersandroid.MainActivity;
import com.example.seersandroid.R;
import com.example.seersandroid.ViewViewModel.Colleges.CollegeLists.CollegeListFragment;
import com.example.seersandroid.ViewViewModel.Colleges.CollegeMap.CollegeMapsFragment;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


/**
 * A placeholder fragment containing a simple view.
 */
public class CollegePlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private CollegePageViewModel collegePageViewModel;

    public static CollegePlaceholderFragment newInstance(int index) {
        CollegePlaceholderFragment fragment = new CollegePlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        collegePageViewModel = ViewModelProviders.of(this).get(CollegePageViewModel.class);
        collegePageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_colleges_container, container, false);

        collegePageViewModel.getText().observe(this.getActivity(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                if(s.equalsIgnoreCase("1")){
                    Fragment fragment = new CollegeListFragment();
                    getChildFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainer, fragment)
                            .commit();
                }else{
                    Fragment fragment = new CollegeMapsFragment();
                    getChildFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainer, fragment)
                            .commit();

                }
            }
        });

        return root;
    }
}