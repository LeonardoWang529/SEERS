package com.example.seersandroid.ViewViewModel.Navigation;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.seersandroid.R;
import com.example.seersandroid.Utilities.OnBackPressedHandler;
import com.example.seersandroid.ViewViewModel.Colleges.CollegesFragment;
import com.example.seersandroid.ViewViewModel.PersonalDashBoard.PersonalDashBoardFragment;
import com.example.seersandroid.ViewViewModel.Questionnairs.QuestionnairsFragment;
import com.example.seersandroid.base.BaseFragment;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import butterknife.BindView;

public class NavigationFragment extends BaseFragment implements OnBackPressedHandler {

    @BindView(R.id.bar)
    BottomAppBar bar;

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.bottom_drawer)
    FrameLayout bottomDrawer;

    @BindView(R.id.main_frame)
    FrameLayout mainFrame;

    private BottomSheetBehavior<View> bottomDrawerBehavior;

    @Override
    protected int layoutRes() { return R.layout.fragment_navigation; }

    @Override
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

/*    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.bottom_nav_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        showSnackbar(menuItem.getTitle());
        return true;
    }*/

    @Override
    public boolean onBackPressed() {
        if (bottomDrawerBehavior.getState() != BottomSheetBehavior.STATE_HIDDEN) {
            bottomDrawerBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            return true;
        }
        return false;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ((AppCompatActivity) getActivity()).setSupportActionBar(bar);
        setUpBottomDrawer(view);
        fab.setOnClickListener(v -> showSnackbar(fab.getContentDescription()));
        fab.show();
        NavigationView navigationView = view.findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(
                item -> {
                    injectView(item.getTitle());
                    return false;
                });

        bar.setFabAlignmentModeAndReplaceMenu(
                BottomAppBar.FAB_ALIGNMENT_MODE_CENTER, R.menu.bottom_nav_menu);
        bar.setHideOnScroll(true);
        bar.setFabAnimationMode(BottomAppBar.FAB_ANIMATION_MODE_SLIDE);
        injectView("Dashboard");
    }

    protected void setUpBottomDrawer(View view) {
        View bottomDrawer = coordinatorLayout.findViewById(R.id.bottom_drawer);
        bottomDrawerBehavior = BottomSheetBehavior.from(bottomDrawer);
        bottomDrawerBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        bar.setNavigationOnClickListener(
                v -> bottomDrawerBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED));
        bar.setNavigationIcon(R.drawable.ic_drawer_menu_24px);
        bar.replaceMenu(R.menu.bottom_nav_menu);
    }

    private void showSnackbar(CharSequence text) {
        Snackbar.make(coordinatorLayout, text, Snackbar.LENGTH_SHORT)
                .setAnchorView(fab.getVisibility() == View.VISIBLE ? fab : bar)
                .show();
    }

    private void injectView(CharSequence layoutName){
        switch (layoutName.toString()){
            case "Dashboard":
                getBaseActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_frame, new PersonalDashBoardFragment())
                        .addToBackStack(null).commit();
                break;
            case "College" :
                getBaseActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_frame, new CollegesFragment())
                    .addToBackStack(null).commit();
                break;
            case "Questionnairs" :
                getBaseActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_frame, new QuestionnairsFragment())
                    .addToBackStack(null).commit();
                break;
            default:
                getBaseActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_frame, new PersonalDashBoardFragment())
                    .addToBackStack(null).commit();
                break;
        }
    }
}
