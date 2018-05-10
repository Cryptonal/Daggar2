package com.example.hammad.daggar2.Injection.Component;


import com.example.hammad.daggar2.Module.ActivityModule;
import com.example.hammad.daggar2.Injection.PerActivity;

import dagger.Module;

@PerActivity
@Module(includes = {ActivityModule.class})
public interface ActivityComponent {
}
