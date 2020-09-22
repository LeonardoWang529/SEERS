package com.example.seersandroid.Utilities.di.module;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;

import com.example.seersandroid.Utilities.ConnectivityUtils.DefaultOnlineChecker;
import com.example.seersandroid.Utilities.ConnectivityUtils.OnlineChecker;
import com.example.seersandroid.Utilities.schedulers.BaseSchedulerProvider;
import com.example.seersandroid.Utilities.schedulers.SchedulerProvider;
import com.example.seersandroid.Utilities.scopes.AppScoped;

import dagger.Module;
import dagger.Provides;

@Module
public class UtilsModule {

    @Provides
    @AppScoped
    ConnectivityManager provideConnectivityManager(Application context) {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

/*    @AppScoped
    @Provides
    ChromeTabsWrapper providesChromeTabsWrapper(Application context) {
        return new ChromeTabsWrapper(context);
    }*/

    @Provides
    @AppScoped
    OnlineChecker onlineChecker(ConnectivityManager cm) {
        return new DefaultOnlineChecker(cm);
    }

    @AppScoped
    @Provides
    BaseSchedulerProvider provideSchedulerProvider(){
        return SchedulerProvider.getInstance();
    }
}
