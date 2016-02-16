package com.ninogenio.authsample.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.ninogenio.authsample.R
import com.ninogenio.authsample.presenter.LoginPresenter
import com.ninogenio.authsample.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity(), LoginView {

    private var loginPresenter: LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginPresenter = LoginPresenter(this, this)

        btn_sign_in.setOnClickListener {
            loginPresenter!!.onLoginClick(et_email.text.toString(),
                    et_password.text.toString())
        }
    }

    override fun setInputEnabled(enabled: Boolean) {
        et_email.isEnabled = enabled
        et_password.isEnabled = enabled
        btn_sign_in.isEnabled = enabled
    }

    override fun setLoading(loading: Boolean) {
        if (loading) {
            pb_login_progress.visibility = View.VISIBLE
            sv_login_form.visibility = View.GONE
        } else {
            pb_login_progress.visibility = View.GONE
            sv_login_form.visibility = View.VISIBLE
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

