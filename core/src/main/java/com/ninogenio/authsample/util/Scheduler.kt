package com.ninogenio.authsample.util

/**
 * Created by gentr on 11-Feb-16.
 */
interface Scheduler {

    fun mainThread(): rx.Scheduler

    fun backgroundThread(): rx.Scheduler

}