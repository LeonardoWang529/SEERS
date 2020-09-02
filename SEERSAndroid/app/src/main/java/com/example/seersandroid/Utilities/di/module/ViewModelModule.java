package com.example.seersandroid.Utilities.di.module;

import com.example.seersandroid.Utilities.ViewModelFactory;
import com.example.seersandroid.Utilities.di.util.ViewModelKey;
import com.example.seersandroid.Utilities.scopes.AppScoped;
import com.example.seersandroid.ViewViewModel.Login.LoginViewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
 /*   @Binds
    @IntoMap
    @ViewModelKey(PersonalDashBoardViewModel.class)
    abstract ViewModel bindPersonalDashBoardViewModel(PersonalDashBoardViewModel personalDashBoardViewModel);
*/
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    abstract ViewModel bindLoginViewModel(LoginViewModel loginViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
