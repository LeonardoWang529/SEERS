package com.example.seersandroid.ViewViewModel.Login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import android.util.Patterns;

import com.example.seersandroid.Utilities.scopes.AppScoped;
import com.example.seersandroid.data.loginModule.LoginRepository;
import com.example.seersandroid.data.Result;
import com.example.seersandroid.data.model.Student;
import com.example.seersandroid.R;

import javax.inject.Inject;

public class LoginViewModel extends ViewModel {

    private final LoginRepository loginRepository;
    private CompositeDisposable disposable;
    private final MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private final MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();


    @Inject
    public LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
        disposable = new CompositeDisposable();
    }

    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }
    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void login(String username, String password) {
        disposable.add(loginRepository.getStudent(username,password)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Student>(){
                    @Override
                    public void onSuccess(Student student) {
                        loginRepository.setLoggedInUser(student);
                        loginResult.setValue(new LoginResult(new LoggedInUserView(student)));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                }));
    }

    public void loginDataChanged(String username, String password) {
        if (!isUserNameValid(username)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
        } else {
            loginFormState.setValue(new LoginFormState(true));
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
