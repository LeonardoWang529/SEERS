package com.example.seersandroid.data.personalDashboardModule;

import com.example.seersandroid.data.Retrofits;
import com.example.seersandroid.data.dao.StudentDAO;

public class StudentRepository{


    Retrofits retrofits;
    StudentDAO studentDAO;


    public StudentRepository(){
        retrofits = Retrofits.getInstance();
        studentDAO = retrofits.retrofit.create(StudentDAO.class);
    }
}
