package com.ninogenio.authsample.interactor

import com.ninogenio.authsample.dummy.UserDummy
import com.ninogenio.authsample.model.UserModel
import com.ninogenio.authsample.util.TextUtils
import rx.Observable

/**
 * Created by gentr on 11-Feb-16.
 */
class UserInteractor {

    fun login(email: String, password: String): Observable<UserModel> {
        return Observable.create { subscriber ->
            // Check if email/password is empty/null
            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                subscriber.onError(Throwable("Email or password is empty"))
            }

            // Simulate API call loading
            try {
                Thread.sleep(3000)
            } catch (e: InterruptedException) {
                subscriber.onError(e)
            }

            // Simulate server logic for logging-in. Check email/password auth
            if (email == UserDummy.EMAIL && password == UserDummy.PASSWORD) {
                // Simulate API response body
                val user = UserModel()
                user.email = UserDummy.EMAIL
                user.password = UserDummy.PASSWORD
                user.name = UserDummy.NAME

                // Return the response to the subscriber
                subscriber.onNext(user)
                subscriber.onCompleted()
            } else {
                // Simulate wrong email/password
                subscriber.onError(Throwable("Wrong email or password"))
            }
        }
    }

}
