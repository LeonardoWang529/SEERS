package com.example.seersandroid.ViewViewModel.Login;

import com.example.seersandroid.R;
import com.example.seersandroid.Utilities.ViewModelFactory;
import com.example.seersandroid.base.BaseFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import javax.inject.Inject;

import butterknife.BindView;

public class SignUpFragment extends BaseFragment {

    @BindView(R.id.signup)
    MaterialButton signup;
    @BindView(R.id.username)
    TextInputEditText username;
    @BindView(R.id.real_name) TextInputEditText real_name;
    @BindView(R.id.school_name) TextInputEditText school_name;
    @BindView(R.id.password) TextInputEditText password;
    @BindView(R.id.confirm_password) TextInputEditText confirm_password;

    @Inject
    ViewModelFactory viewModelFactory;

    private StudentViewModel studentViewModel;

    @Override
    protected int layoutRes() {
        return R.layout.fragment_signup;
    }

}
