package com.example.seersandroid.ViewViewModel.Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seersandroid.R;
import com.example.seersandroid.Utilities.ViewModelFactory;
import com.example.seersandroid.ViewViewModel.Navigation.NavigationFragment;
import com.example.seersandroid.base.BaseFragment;
import com.example.seersandroid.data.model.Student;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;


public class LoginFragment extends BaseFragment {
    private static final String TAG = LoginFragment.class.getSimpleName();

    @BindView(R.id.login) Button login;
    @BindView(R.id.signup) Button signup;
    @BindView(R.id.username) EditText username;
    @BindView(R.id.password) EditText password;
    @BindView(R.id.forgetPassword) Button forgetPassword;
    //@BindView(R.id.loading) ProgressBar loading;

    @Inject ViewModelFactory viewModelFactory;
    private StudentViewModel studentViewModel;

    @Override
    protected int layoutRes() { return R.layout.fragment_login; }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        studentViewModel = new ViewModelProvider(this,viewModelFactory).get(StudentViewModel.class);

        studentViewModel.getLoginFormState().observe(getBaseActivity(), new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                login.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    username.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    password.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        studentViewModel.getLoginResult().observe(getBaseActivity(), new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                //loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    updateUiWithUser(loginResult.getSuccess());
                }
                //Complete and destroy login activity once successful
                //finish();
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                studentViewModel.loginDataChanged(username.getText().toString(),
                        password.getText().toString());
            }
        };
        username.addTextChangedListener(afterTextChangedListener);
        password.addTextChangedListener(afterTextChangedListener);
        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    studentViewModel.saveStudent();
                    studentViewModel.login(username.getText().toString(),
                            password.getText().toString());
                }
                return false;
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //loading.setVisibility(View.VISIBLE);
                studentViewModel.saveStudent();

                studentViewModel.login(username.getText().toString(),
                        password.getText().toString());
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getBaseActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.screenContainer, new SignUpFragment())
                        .addToBackStack(null).commit();
            }
        });
    }

    private void updateUiWithUser(Student model) {
        // TODO : initiate successful logged in experience
        //String welcome = getString(R.string.welcome) + model.getDisplayName();
        //Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
/*        Intent i = new Intent(getBaseActivity(), NavigationFragment.class);
        startActivity(i);*/

        getBaseActivity().getSupportFragmentManager().beginTransaction().replace(R.id.screenContainer, new NavigationFragment())
                .addToBackStack(null).commit();
    }

    private void showLoginFailed(Throwable errorString) {
        Toast.makeText(getContext(), errorString.getMessage(), Toast.LENGTH_SHORT).show();
    }


}
