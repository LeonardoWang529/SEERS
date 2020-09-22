package com.example.seersandroid.ViewViewModel.StudentID;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.seersandroid.R;
import com.example.seersandroid.Utilities.ViewModelFactory;
import com.example.seersandroid.ViewViewModel.PersonalDashBoard.PersonalDashBoardViewModel;
import com.example.seersandroid.base.BaseFragment;
import com.example.seersandroid.data.model.Student;
import com.google.android.material.textfield.TextInputEditText;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;

public class StudentIdFragment extends BaseFragment {

    @BindView(R.id.schoolName) TextView schoolName;
    @BindView(R.id.schoolLogo) ImageView schoolLogo;
    @BindView(R.id.userImage) ImageView userImage;
    @BindView(R.id.userName) TextView userName;
    @BindView(R.id.userPos) TextView userPos;
    @BindView(R.id.userMoney) TextView userMoney;
    @BindView(R.id.userMajor) TextView userMajor;

    @Inject
    ViewModelFactory viewModelFactory;
    private PersonalDashBoardViewModel personalDashBoardViewModel;

    @Override
    protected int layoutRes() { return R.layout.fragment_studentid; }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        personalDashBoardViewModel = new ViewModelProvider(getBaseActivity(),viewModelFactory).get(PersonalDashBoardViewModel.class);
        personalDashBoardViewModel.getStudent().observe(getBaseActivity(), new Observer<Student>() {
            @Override
            public void onChanged(Student student) {
                setStudentInfo(student);
            }
        });
    }

    public void setStudentInfo(Student student){
        //schoolName.setText();
        //Picasso.get().load(student.getAvater).resize(100,100).into(userImage);
        userName.setText(student.getName());
    }

}
