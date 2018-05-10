package com.example.hammad.daggar2.Injection.Component;

import com.example.hammad.daggar2.Injection.Module.FragmentModule;
import com.example.hammad.daggar2.Module.ActivityModule;
import com.example.hammad.daggar2.Injection.ConfigPersistent;

import dagger.Component;

@ConfigPersistent
@Component(dependencies = AppComponent.class)
public interface ConfigPersistentComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);

    FragmentComponent fragmentComponent(FragmentModule fragmentModule);
}

