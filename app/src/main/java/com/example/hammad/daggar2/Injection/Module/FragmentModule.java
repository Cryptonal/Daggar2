package com.example.hammad.daggar2.Injection.Module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.example.hammad.daggar2.Injection.ActivityContext;
import com.example.hammad.daggar2.features.base.BaseFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment){
        this.fragment = fragment;
    }

    @Provides
    public Fragment providesFragment(){
        return fragment;
    }

    @Provides
    public Activity provideactivity(){
        return fragment.getActivity();
    }

    @Provides
    @ActivityContext
    public Context providesContext(){
        return fragment.getActivity();
    }
}
