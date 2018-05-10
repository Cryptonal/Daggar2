package com.example.hammad.daggar2.Module;

import com.example.hammad.daggar2.Data.networkoperations.AuthService;
import com.example.hammad.daggar2.Data.networkoperations.ErrorUtils;

import java.net.Authenticator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = {NetworkModule.class})
public class ApiModule {

    @Provides
    @Singleton
    AuthService provideAuthApi(Retrofit retrofit){
        return retrofit.create(AuthService.class);
    }
    @Provides
    @Singleton
    ErrorUtils provideAPIError(Retrofit retrofit) {
        return new ErrorUtils(retrofit);
    }
}
