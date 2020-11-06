package com.example.seersandroid.ViewViewModel.Navigation;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.seersandroid.R;
import com.example.seersandroid.ViewViewModel.Colleges.CollegesFragment;
import com.example.seersandroid.ViewViewModel.PersonalDashBoard.PersonalDashBoardFragment;
import com.example.seersandroid.ViewViewModel.Questionnairs.QuestionnairsFragment;
import com.example.seersandroid.ViewViewModel.Recommendation.RecommendationFragment;
import com.example.seersandroid.base.BaseActivity;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import butterknife.BindView;

public class NavigationActivity extends BaseActivity {

    @BindView(R.id.bar)
    BottomAppBar bar;

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.bottom_drawer)
    FrameLayout bottomDrawer;

    private BottomSheetBehavior<View> bottomDrawerBehavior;

    @Override
    protected int layoutRes() {
        return R.layout.fragment_navigation;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setSupportActionBar(bar);
        setUpBottomDrawer();
        fab.setOnClickListener(v -> {
            if(getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount()-1)
                    .getName().equals("fabFragment")){
                onBackPressed();
            }else {
                replaceFragment(RecommendationFragment.class, "fabFragment");
            }
        });
        fab.show();
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(
                item -> {
                    injectView(item.getTitle());
                    return false;
                });

        bar.setFabAlignmentModeAndReplaceMenu(
                BottomAppBar.FAB_ALIGNMENT_MODE_CENTER, R.menu.bottom_nav_menu);
        bar.setHideOnScroll(true);
        bar.setFabAnimationMode(BottomAppBar.FAB_ANIMATION_MODE_SLIDE);
        replaceFragment(PersonalDashBoardFragment.class,"dashboard");
    }

    public void replaceFragment(Class fragmentClass, String fragmentName){
        addFragmentToActivity(fragmentClass, R.id.main_frame,fragmentName);
        if (bottomDrawerBehavior.getState() != BottomSheetBehavior.STATE_HIDDEN) {
            bottomDrawerBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        }
    }

    @Override
    public void onBackPressed() {
        if (bottomDrawerBehavior.getState() != BottomSheetBehavior.STATE_HIDDEN) {
            bottomDrawerBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        }
        //if it is RecommendationFragment hide it.
        if(getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        }
    }

    protected void setUpBottomDrawer() {
        View bottomDrawer = coordinatorLayout.findViewById(R.id.bottom_drawer);
        bottomDrawerBehavior = BottomSheetBehavior.from(bottomDrawer);
        bottomDrawerBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        bar.setNavigationOnClickListener(
                v -> bottomDrawerBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED));
        bar.setNavigationIcon(R.drawable.ic_drawer_menu_24px);
        bar.replaceMenu(R.menu.bottom_nav_menu);
    }

    private void injectView(CharSequence layoutName){
        switch (layoutName.toString()){
            case "College" :
                replaceFragment(CollegesFragment.class, "college");
                break;
            case "Questionnairs" :
                replaceFragment(QuestionnairsFragment.class,"questionnairs");
                break;
            default:
                replaceFragment(PersonalDashBoardFragment.class, "dashboard");
                break;
        }
    }
}
