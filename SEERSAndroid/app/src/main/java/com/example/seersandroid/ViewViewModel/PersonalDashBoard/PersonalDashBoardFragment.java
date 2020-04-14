package com.example.seersandroid.ViewViewModel.PersonalDashBoard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.seersandroid.R;
import com.example.seersandroid.data.model.Student;
import com.example.seersandroid.databinding.FragmentPersonaldashboardBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


public class PersonalDashBoardFragment extends Fragment {

    private PersonalDashBoardViewModel personalDashBoardViewModel;
    private FragmentPersonaldashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        personalDashBoardViewModel =
                ViewModelProviders.of(this).get(PersonalDashBoardViewModel.class);

        binding = FragmentPersonaldashboardBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();

        personalDashBoardViewModel.getStudent().observe(getActivity(), new Observer<Student>() {
            @Override
            public void onChanged(Student student) {
                setPersonalAvatorandName(student);
                setPassScoreFragment(student);
                setCurrentScoreFragment(student);
            }
        });

        return v;
    }

    public void setPersonalAvatorandName(Student s){
        binding.name.setText(s.getName());
        binding.localtion.setText(s.getName());
        //binding.avater.setImageBitmap();
    }

    public void setPassScoreFragment(Student s){
        //pass to fragment, because oberser change will auto change the fragments,
        //no need to add another ovserve on each fragments.
    }

    public void setCurrentScoreFragment(Student s){
        //pass to fragment
    }

}
