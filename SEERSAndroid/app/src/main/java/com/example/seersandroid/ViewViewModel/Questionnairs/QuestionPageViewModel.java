package com.example.seersandroid.ViewViewModel.Questionnairs;

import com.example.seersandroid.Classes.OperationListener;
import com.example.seersandroid.data.Result;
import com.example.seersandroid.data.model.Question;
import com.example.seersandroid.data.questionModule.QuestionnairRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuestionPageViewModel extends ViewModel {

    private QuestionListResult questionListResult;
    private MutableLiveData<List<Question>> mQuestionList = new MutableLiveData<>();

    QuestionnairRepository questionnairRepository;

    public QuestionPageViewModel(){
        questionnairRepository = new QuestionnairRepository();
    }

    //divide question to two or three pages.

    public void setIndex(int index) {
        switch(index){
            case 1:
                mQuestionList.setValue(questionListResult.getSuccess().subList(0,20));
                break;
            case 2:
                mQuestionList.setValue(questionListResult.getSuccess().subList(20,40));
                break;
        }

    }

    public LiveData<List<Question>> getQuestionList() {
        return mQuestionList;
    }

    public void getQuestionData(){
        questionnairRepository.setListerner(getQuestionDataListener);
        questionnairRepository.getAllQuesitions();
    }

    OperationListener getQuestionDataListener = new OperationListener() {
        @Override
        public void onSuccess(Result result) {
            questionListResult = new QuestionListResult(((Result.Success<List<Question>>) result).getData());
        }

        @Override
        public void onError(Result result) {

        }

        @Override
        public void onPreExecution() {

        }

        @Override
        public void onPostExecution() {

        }

        @Override
        public void onOperationProgressUpdate(String... updateParams) {

        }
    };

}