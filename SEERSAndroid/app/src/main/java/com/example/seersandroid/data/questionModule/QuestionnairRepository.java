package com.example.seersandroid.data.questionModule;

import com.example.seersandroid.Classes.Operation;
import com.example.seersandroid.Classes.OperationListener;
import com.example.seersandroid.data.Retrofits;
import com.example.seersandroid.data.dao.QuestionDAO;
import com.example.seersandroid.data.model.Question;

public class QuestionnairRepository implements Operation {

    Retrofits retrofits;
    QuestionDAO questionDAO;
    OperationListener mListener;

    public QuestionnairRepository(){
        retrofits = Retrofits.getInstance();
        questionDAO = retrofits.retrofit.create(QuestionDAO.class);
    }


    @Override
    public void setListerner(OperationListener operationListener) {
        this.mListener = operationListener;
    }

    public void getAllQuesitions(){}

}
