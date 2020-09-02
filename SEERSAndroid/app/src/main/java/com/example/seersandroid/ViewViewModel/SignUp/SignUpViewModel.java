package com.example.seersandroid.ViewViewModel.SignUp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.util.Patterns;

import com.example.seersandroid.R;
import com.example.seersandroid.data.Result;
import com.example.seersandroid.data.model.Student;
import com.example.seersandroid.data.signUpModule.SignUpRepository;

public class SignUpViewModel extends ViewModel {

    private MutableLiveData<SignUpFormState> signupFormState = new MutableLiveData<>();
    private MutableLiveData<SignUpResult> signupResult = new MutableLiveData<>();
    private SignUpRepository signUpRepository;

    SignUpViewModel(SignUpRepository signUpRepository) {
        this.signUpRepository = signUpRepository;
    }

    LiveData<SignUpFormState> getLoginFormState() {
        return signupFormState;
    }

    LiveData<SignUpResult> getLoginResult() {
        return signupResult;
    }

    public void login(String username, String password) {
        // can be launched in a separate asynchronous job
        signUpRepository.signup(username, password);
    }


    public void loginDataChanged(String username, String password) {
        if (!isUserNameValid(username)) {
            signupFormState.setValue(new SignUpFormState(R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            signupFormState.setValue(new SignUpFormState(null, R.string.invalid_password));
        } else {
            signupFormState.setValue(new SignUpFormState(true));
        }
    }

    // A placeholder username validation check
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        if (username.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            return !username.trim().isEmpty();
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }
}
