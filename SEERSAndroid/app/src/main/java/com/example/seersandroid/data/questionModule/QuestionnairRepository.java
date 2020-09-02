package com.example.seersandroid.data.questionModule;

import com.example.seersandroid.data.Result;
import com.example.seersandroid.data.Retrofits;
import com.example.seersandroid.data.dao.QuestionDAO;
import com.example.seersandroid.data.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionnairRepository{

    Retrofits retrofits;
    QuestionDAO questionDAO;


    public QuestionnairRepository(){
        retrofits = Retrofits.getInstance();
        questionDAO = retrofits.retrofit.create(QuestionDAO.class);
    }


    public void getAllQuesitions(){
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));
        questions.add(new Question("Do you like sports?","yes"));


    }

}
