package com.example.hammad.daggar2.features.base;

public interface Presenter<A extends MvpView> {


    void attachView(A mvpView);

    void detachView();
}
