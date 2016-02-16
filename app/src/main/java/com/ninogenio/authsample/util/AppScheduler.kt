package com.ninogenio.authsample.util

import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by gentr on 11-Feb-16.
 */
class AppScheduler : Scheduler {
    override fun mainThread(): rx.Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun backgroundThread(): rx.Scheduler {
        return Schedulers.io()
    }
}
