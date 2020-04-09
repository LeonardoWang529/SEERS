package com.example.seersandroid.ViewViewModel.Colleges;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.seersandroid.R;
import com.example.seersandroid.ViewViewModel.Colleges.CollegeLists.CollegeListFragment;
import com.example.seersandroid.ViewViewModel.Colleges.CollegeMap.CollegeMapsFragment;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_colleges_container, container, false);

        pageViewModel.getText().observe(this.getActivity(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                if(s.equalsIgnoreCase("1")){
                    Fragment fragment = new CollegeListFragment();
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .add(R.id.fragmentContainer, fragment)
                            .commit();
                }else{
                    Fragment fragment = new CollegeMapsFragment();
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .add(R.id.fragmentContainer, fragment)
                            .commit();
                }
            }
        });
        return root;
    }
}