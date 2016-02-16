package com.ninogenio.authsample.view

/**
 * Created by gentr on 11-Feb-16.
 */
interface LoginView {

    fun setInputEnabled(enabled: Boolean)

    fun setLoading(loading: Boolean)

    fun showMessage(message: String)

}
