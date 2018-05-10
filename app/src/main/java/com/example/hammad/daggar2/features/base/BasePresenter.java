package com.example.hammad.daggar2.features.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import rx.Observable;
import rx.Single;

public class BasePresenter<A extends MvpView> implements Presenter<A>{
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private A mvpView;

    @Override
    public void attachView(A mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void detachView() {
        mvpView = null;
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.clear();
        }
    }

    protected boolean isViewAttached() {
        return mvpView != null;
    }

    protected A getView() {
        return mvpView;
    }

    protected void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    private static class MvpViewNotAttachedException extends RuntimeException {
        MvpViewNotAttachedException() {
            super(
                    "Please call Presenter.attachView(MvpView) before"
                            + " requesting data to the Presenter");
        }
    }

    /**
     * Encapsulate the result of an rx Observable. This model is meant to be used by the children
     * presenters to easily keep a reference to the latest loaded result so that it can be easily
     * emitted again when on configuration changes.
     */
    protected static class DataResult<A> {

        private A data;
        private Throwable error;

        public DataResult(A data) {
            this.data = data;
        }

        public DataResult(Throwable error) {
            this.error = error;
        }

        public Single<A> toSingle() {
            if (error != null) {
                return Single.error(error);
            }
            return Single.just(data);
        }

        public Observable<A> toObservable() {
            if (error != null) {
                return Observable.error(error);
            }
            return Observable.just(data);
        }
    }
}
