package com.ninogenio.authsample.presenter

import android.content.Context

import com.ninogenio.authsample.interactor.UserInteractor
import com.ninogenio.authsample.model.UserModel
import com.ninogenio.authsample.view.LoginView

import rx.Subscriber

/**
 * Created by gentr on 11-Feb-16.
 */
class LoginPresenter(private val context: Context, private val loginView: LoginView) : Presenter() {

    private val userInteractor: UserInteractor

    init {

        userInteractor = UserInteractor()
    }

    fun onLoginClick(email: String, password: String) {
        addSubscription(userInteractor.login(email, password).subscribeOn(scheduler.backgroundThread()).observeOn(scheduler.mainThread()).subscribe(object : Subscriber<UserModel>() {

            override fun onStart() {
                super.onStart()
                loginView.setLoading(true)
                loginView.setInputEnabled(false)
            }

            override fun onCompleted() {
                loginView.setLoading(false)
                loginView.setInputEnabled(true)
            }

            override fun onError(e: Throwable) {
                loginView.setLoading(false)
                loginView.setInputEnabled(true)
                loginView.showMessage(e.message as String)
            }

            override fun onNext(userModel: UserModel) {
                loginView.showMessage("Hello " + userModel.name + ". You have logged-in")
                // Usually this is where we call an Intent to the Home Activity
            }
        }))
    }

}
