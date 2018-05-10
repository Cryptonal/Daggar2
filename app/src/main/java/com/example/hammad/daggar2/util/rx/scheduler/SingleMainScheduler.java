package com.example.hammad.daggar2.util.rx.scheduler;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SingleMainScheduler<A> extends BaseScheduler<A> {

    protected SingleMainScheduler() {
        super(Schedulers.single(), AndroidSchedulers.mainThread());
    }
}
