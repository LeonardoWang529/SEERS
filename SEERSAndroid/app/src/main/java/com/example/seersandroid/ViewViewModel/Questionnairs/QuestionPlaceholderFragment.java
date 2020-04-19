package com.example.seersandroid.ViewViewModel.Questionnairs;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.seersandroid.Classes.OnItemClickListener;
import com.example.seersandroid.R;
import com.example.seersandroid.data.model.Question;
import com.example.seersandroid.databinding.FragmentQuestionnairsContainerBinding;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A placeholder fragment containing a simple view.
 */
public class QuestionPlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private QuestionPageViewModel questionPageViewModel;
    FragmentQuestionnairsContainerBinding binding;

    public static QuestionPlaceholderFragment newInstance(int index) {
        QuestionPlaceholderFragment fragment = new QuestionPlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        questionPageViewModel = ViewModelProviders.of(this).get(QuestionPageViewModel.class);
        questionPageViewModel.getQuestionData();

        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        questionPageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        binding = FragmentQuestionnairsContainerBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();

        final RecyclerView questionRecycleView = binding.questionRecyclerView;
        questionRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));

        questionPageViewModel.getQuestionList().observe(getActivity(), new Observer<List<Question>>() {
            @Override
            public void onChanged(List<Question> questions) {
                QuestionListAdapter questionListAdapter = new QuestionListAdapter();
                questionRecycleView.setAdapter(questionListAdapter);
                questionListAdapter.setListerner(itemClickListener);
                questionListAdapter.setQuestionList(questions);
                questionListAdapter.notifyDataSetChanged();
                //getActivity().setResult(Activity.RESULT_OK);
            }
        });

        return root;
    }

    private OnItemClickListener itemClickListener = new OnItemClickListener() {
        @Override
        public void onClick(Object o) {

        }
    };
}