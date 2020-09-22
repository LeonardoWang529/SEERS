package com.example.seersandroid.Utilities;

import com.example.seersandroid.R;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public class FeatureUtils {

    private static final int MAIN_ACTIVITY_FRAGMENT_CONTAINER_ID = R.id.main_frame;

    public static Fragment getCurrentFragment(FragmentActivity activity) {
        return activity
                .getSupportFragmentManager()
                .findFragmentById(MAIN_ACTIVITY_FRAGMENT_CONTAINER_ID);
    }

}
