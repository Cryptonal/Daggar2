package com.example.hammad.daggar2.Data.networkoperations;

import com.example.hammad.daggar2.Data.model.Response.APIError;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ErrorUtils {
    Retrofit retrofit;

    public ErrorUtils(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public APIError parseError(Response<?> response) {
        Converter<ResponseBody, APIError> converter =
                retrofit.responseBodyConverter(APIError.class, new Annotation[0]);

        APIError error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new APIError();
        }

        return error;
    }

}
