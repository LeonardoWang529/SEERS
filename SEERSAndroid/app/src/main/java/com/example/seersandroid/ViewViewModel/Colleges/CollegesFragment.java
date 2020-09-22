package com.example.seersandroid.ViewViewModel.Colleges;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.seersandroid.R;
import com.example.seersandroid.base.BaseFragment;
import com.example.seersandroid.databinding.FragmentCollegesBinding;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

public class CollegesFragment extends BaseFragment {

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.tabs)
    TabLayout tabs;

    @Override
    protected int layoutRes() { return R.layout.fragment_colleges; }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        CollegeSectionsPagerAdapter sectionsPagerAdapter = new CollegeSectionsPagerAdapter(this.getContext(),
                getActivity().getSupportFragmentManager());
        viewPager.setAdapter(sectionsPagerAdapter);
        tabs.setupWithViewPager(viewPager);

    }
}