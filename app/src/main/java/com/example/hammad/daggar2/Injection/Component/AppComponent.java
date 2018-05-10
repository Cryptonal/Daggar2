package com.example.hammad.daggar2.Injection.Component;

import android.app.Application;
import android.content.Context;

import com.example.hammad.daggar2.Data.DataManager;
import com.example.hammad.daggar2.Module.AppModule;
import com.example.hammad.daggar2.Injection.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    @ApplicationContext
    Context context();

    Application application();
    DataManager dataManager();
}
