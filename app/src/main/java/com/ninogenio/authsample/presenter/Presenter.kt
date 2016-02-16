package com.ninogenio.authsample.presenter

import com.ninogenio.authsample.util.AppScheduler
import com.ninogenio.authsample.util.Scheduler
import rx.Subscription
import java.util.*

/**
 * Created by gentr on 11-Feb-16.
 */
open class Presenter {

    private val subscriptions = ArrayList<Subscription>()
    protected var scheduler: Scheduler

    init {
        scheduler = AppScheduler()
    }

    protected fun addSubscription(subscription: Subscription) {
        subscriptions.add(subscription)
    }

    fun finish() {
        for (sub in subscriptions) {
            sub.unsubscribe()
        }
    }

}
