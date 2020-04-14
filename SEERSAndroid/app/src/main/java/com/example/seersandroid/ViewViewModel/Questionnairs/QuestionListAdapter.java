package com.example.seersandroid.ViewViewModel.Questionnairs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.seersandroid.Classes.OnItemClick;
import com.example.seersandroid.Classes.OnItemClickListener;
import com.example.seersandroid.R;
import com.example.seersandroid.data.model.Question;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QuestionListAdapter extends RecyclerView.Adapter<QuestionListAdapter.QuestionItem> implements OnItemClick {
    List<Question> questionList;
    OnItemClickListener itemClickListener;

    public void setQuestionList(List<Question> questionList){
        this.questionList = questionList;
    }

    @Override
    public void setListerner(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public class QuestionItem extends RecyclerView.ViewHolder {
        TextView question;
        CheckBox checkBox;
        public QuestionItem(@NonNull View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.question);
            checkBox = itemView.findViewById(R.id.yesorno);
        }
    }

    @NonNull
    @Override
    public QuestionItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_questionlist,parent,false);
        return new QuestionItem(v);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionItem holder, int position) {
        //holder.question.setText(questionList.get(position).getQuestion());
        itemClickListener.onClick(questionList.get(position));
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }


}
