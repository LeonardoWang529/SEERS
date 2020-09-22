package com.example.seersandroid;

import android.os.Bundle;

import com.example.seersandroid.Utilities.FeatureUtils;
import com.example.seersandroid.Utilities.OnBackPressedHandler;
import com.example.seersandroid.ViewViewModel.Login.LoginFragment;
import com.example.seersandroid.ViewViewModel.PersonalDashBoard.CurrentScoreFragment;
import com.example.seersandroid.base.BaseActivity;

import javax.inject.Inject;

import androidx.fragment.app.Fragment;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null)
            getSupportFragmentManager().beginTransaction().add(R.id.screenContainer, new LoginFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        if (handleFragmentOnBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    private boolean handleFragmentOnBackPressed() {
        Fragment currentFragment = FeatureUtils.getCurrentFragment(this);
        return currentFragment instanceof OnBackPressedHandler
                && ((OnBackPressedHandler) currentFragment).onBackPressed();
    }
}
