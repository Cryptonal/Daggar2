package com.example.hammad.daggar2.util.rx.scheduler;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NewThreadMainScheduler<A> extends BaseScheduler<A> {

    protected NewThreadMainScheduler() {
        super(Schedulers.newThread(), AndroidSchedulers.mainThread());
    }
}
