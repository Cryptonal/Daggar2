package com.example.hammad.daggar2.Module;

import android.app.Activity;
import android.content.Context;

import com.example.hammad.daggar2.Injection.ActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    Activity activity;

    public ActivityModule(Activity activity){
        this.activity = activity;
    }

    @Provides
    public Activity activity(){
        return activity;
    }

    @Provides
    @ActivityContext
    public Context provideContext(){
        return activity;
    }
}
