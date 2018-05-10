package com.example.hammad.daggar2.Module;

import android.app.Application;
import android.content.Context;

import com.example.hammad.daggar2.Injection.ApplicationContext;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ApiModule.class})
public class AppModule {

    private Application application;

        public AppModule(Application application){
            this.application = application;
        }

        @Provides
        Application provideApplication(){
            return application;
        }
    @Provides
    @ApplicationContext
    Context provideContext(){
            return application;
    }
//    @Provides
//    SharedPreferences providesharedPreferences(@ApplicationContext Context context){
//            return context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
//    }
}
