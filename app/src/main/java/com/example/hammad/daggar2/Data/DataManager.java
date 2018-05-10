package com.example.hammad.daggar2.Data;

import com.example.hammad.daggar2.Data.model.Response.APIError;
import com.example.hammad.daggar2.Data.networkoperations.AuthService;
import com.example.hammad.daggar2.Data.networkoperations.ErrorUtils;
import com.example.hammad.daggar2.Injection.Component.AppComponent;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Response;

@Singleton
public class DataManager {

    @Inject
    public AuthService authService;
    public ErrorUtils errorUtils;

    @Inject
    public DataManager(AuthService authService, ErrorUtils errorUtils){
        this.authService = authService;
        this.errorUtils = errorUtils;
    }

    public APIError parseError(Response response){
        return errorUtils.parseError(response);
    }
}
