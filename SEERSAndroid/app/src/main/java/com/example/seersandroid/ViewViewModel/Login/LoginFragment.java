package com.example.seersandroid.ViewViewModel.Login;

import android.os.Bundle;
import android.view.View;

import com.example.seersandroid.R;
import com.example.seersandroid.Utilities.ViewModelFactory;
import com.example.seersandroid.Utilities.scopes.ActivityScoped;
import com.example.seersandroid.base.BaseFragment;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import dagger.android.support.DaggerFragment;


public class LoginFragment extends BaseFragment {

    @Inject ViewModelFactory viewModelFactory;

    private LoginViewModel viewModel;

    @Override
    protected int layoutRes() { return R.layout.activity_login; }
}
