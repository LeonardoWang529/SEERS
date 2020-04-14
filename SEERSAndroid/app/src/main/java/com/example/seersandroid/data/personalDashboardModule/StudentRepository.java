package com.example.seersandroid.data.personalDashboardModule;

import com.example.seersandroid.Classes.Operation;
import com.example.seersandroid.Classes.OperationListener;
import com.example.seersandroid.data.Retrofits;
import com.example.seersandroid.data.dao.StudentDAO;

public class StudentRepository implements Operation {

    OperationListener mListener;
    Retrofits retrofits;
    StudentDAO studentDAO;

    @Override
    public void setListerner(OperationListener operationListener) {
        this.mListener = operationListener;
    }

    public StudentRepository(){
        retrofits = Retrofits.getInstance();
        studentDAO = retrofits.retrofit.create(StudentDAO.class);
    }
}
