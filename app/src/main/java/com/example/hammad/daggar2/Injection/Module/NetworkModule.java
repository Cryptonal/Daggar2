package com.example.hammad.daggar2.Module;

import android.content.Context;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.readystatesoftware.chuck.ChuckInterceptor;
import com.tspoon.traceur.RxJavaAssemblyException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

@Module
public class NetworkModule {
    private Context context;
    private String baseUrl;

    public NetworkModule(final Context context, String baseUrl){
        this.context=context;
        this.baseUrl=baseUrl;
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor,
                                            StethoInterceptor stethoInterceptor,
                                            ChuckInterceptor chuckInterceptor){
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder()
                .addInterceptor(chuckInterceptor)
                .addInterceptor(stethoInterceptor)
                .addInterceptor(httpLoggingInterceptor);

        return httpClientBuilder.build();

    }

    @Provides
    @Singleton
    public HttpLoggingInterceptor providehttpLoggingInterceptor(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.d(message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }

    @Provides
    @Singleton
    public StethoInterceptor providestethoInterceptor(){
        return new StethoInterceptor();
    }

    @Provides
    @Singleton
    public ChuckInterceptor providechuckInterceptor(){
        return new ChuckInterceptor(context);
    }

    @Provides
    @Singleton
    public Gson provideGson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
         gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
         return gsonBuilder.create();
    }
}
