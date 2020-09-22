package com.example.seersandroid.ViewViewModel.Login;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import android.util.Patterns;

import com.example.seersandroid.Utilities.scopes.AppScoped;
import com.example.seersandroid.data.model.Student;
import com.example.seersandroid.R;
import com.example.seersandroid.data.source.student.StudentRepository;

import javax.inject.Inject;

@AppScoped
public class StudentViewModel extends ViewModel {

    @NonNull
    private final StudentRepository mRepository;
    private CompositeDisposable disposable;
    private final MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();

    @Inject
    public StudentViewModel(@NonNull StudentRepository studentRepository) {
        mRepository = studentRepository;
        disposable = new CompositeDisposable();
    }

    LiveData<LoginFormState> getLoginFormState() { return loginFormState; }
    LiveData<LoginResult> getLoginResult() { return loginResult; }

    public void login(String username, String password){
        disposable.add(mRepository.getStudent(username,password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .subscribe(
                        student -> loginResult.setValue(new LoginResult(student)),
                        error-> loginResult.setValue(new LoginResult(error))
                ));
    }

    public void saveStudent(){
        Student s = new Student();
        s.setUserId("0");
        s.setUserName("leo9081");
        s.setPassword("123456");
        s.setName("Yi_Wang");
        s.setGender("male");
        s.setSAT_math("300");
        s.setSAT_verbal("300");
        s.setExpense_limit("10000000");

        mRepository.saveStudent(s);
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

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }
}
