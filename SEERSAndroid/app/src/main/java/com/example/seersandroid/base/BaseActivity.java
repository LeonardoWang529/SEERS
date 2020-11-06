package com.example.seersandroid.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

import static kotlin.jvm.internal.Intrinsics.checkNotNull;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    @LayoutRes
    protected abstract int layoutRes();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutRes());
        ButterKnife.bind(this);
    }

    public void addFragmentToActivity(Class fragmentClass, int frameId, @Nullable String fragmentName) {
        Fragment fragment = null;
        try{
            fragment = (Fragment) fragmentClass.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        getSupportFragmentManager().beginTransaction().replace(frameId,fragment)
                .addToBackStack(fragmentName).commit();
    }
}