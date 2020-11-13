package com.example.seersandroid.ViewViewModel.PersonalDashBoard;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.seersandroid.MainActivity;
import com.example.seersandroid.R;
import com.example.seersandroid.Utilities.ViewModelFactory;
import com.example.seersandroid.Utilities.scopes.ActivityScoped;
import com.example.seersandroid.ViewViewModel.Navigation.NavigationActivity;
import com.example.seersandroid.ViewViewModel.StudentID.StudentIdFragment;
import com.example.seersandroid.base.BaseFragment;
import com.example.seersandroid.data.model.Student;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

@ActivityScoped
public class PersonalDashBoardFragment extends BaseFragment {

    @BindView(R.id.avater) ImageView avater;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.localtion) TextView localtion;

    @Inject
    ViewModelFactory viewModelFactory;
    private PersonalDashBoardViewModel personalDashBoardViewModel;

    @Override
    protected int layoutRes() { return R.layout.fragment_personaldashboard; }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        personalDashBoardViewModel = new ViewModelProvider(this, viewModelFactory)
                .get(PersonalDashBoardViewModel.class);

        personalDashBoardViewModel.getStudent().observe(getBaseActivity(), new Observer<Student>() {
            @Override
            public void onChanged(Student student) {
                setPersonalAvatorandName(student);
                setPassScoreFragment();
                setCurrentScoreFragment();
                setAvaterOnclickListener();
            }
        });
    }

    public void setAvaterOnclickListener(){
        avater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*StudentIdFragment studentIdFragment = new StudentIdFragment();
                getBaseActivity().getSupportFragmentManager().beginTransaction()
                        .add(R.id.main_dashboard, studentIdFragment)
                        .commit();*/
                //onButtonShowPopupWindowClick(view.getRootView());
                ((NavigationActivity)getActivity()).replaceFragment(StudentIdFragment.class, "student");
            }
        });
    }

    private void addDialogLauncher(
            ViewGroup viewGroup, @StringRes int stringResId, AlertDialog.Builder alertDialogBuilder) {
        MaterialButton dialogLauncherButton = new MaterialButton(viewGroup.getContext());
        dialogLauncherButton.setOnClickListener(v -> alertDialogBuilder.show());
        dialogLauncherButton.setText(stringResId);
        viewGroup.addView(dialogLauncherButton);
    }


    public void onButtonShowPopupWindowClick(View view) {
/*        LinearLayout dialogLaunchersLayout = view.findViewById(R.id.dialog_launcher_buttons_layout);
        addDialogLauncher(
                view,
                "San Jose State University",
                new MaterialAlertDialogBuilder(getContext())
                        .setTitle("San Jose State University")
                        .setView(R.layout.fragment_studentid));*/

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater) getBaseActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.fragment_studentid, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

    public void setPersonalAvatorandName(Student s){
        name.setText(s.getFirstName()+ " " + s.getLastName());
        localtion.setText("San Jose");
        //binding.avater.setImageBitmap();
    }

    public void setPassScoreFragment(){
        //pass to fragment, because oberser change will auto change the fragments,
        //no need to add another ovserve on each fragments.
        PassScoreFragment passScoreFragment = new PassScoreFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .add(R.id.pased_score,passScoreFragment)
                .commit();

    }

    public void setCurrentScoreFragment(){
        CurrentScoreFragment currentScoreFragment = new CurrentScoreFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .add(R.id.current_score,currentScoreFragment)
                .commit();

    }

}
