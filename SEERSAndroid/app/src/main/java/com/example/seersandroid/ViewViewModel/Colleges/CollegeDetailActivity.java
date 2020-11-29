package com.example.seersandroid.ViewViewModel.Colleges;

import android.os.Bundle;
import android.widget.TextView;

import com.example.seersandroid.R;
import com.example.seersandroid.base.BaseActivity;

import androidx.annotation.Nullable;
import butterknife.BindView;

public class CollegeDetailActivity extends BaseActivity {

    @BindView(R.id.school_name)
    TextView school_name;

    @Override
    protected int layoutRes() {
        return R.layout.activity_college_detail;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


}
