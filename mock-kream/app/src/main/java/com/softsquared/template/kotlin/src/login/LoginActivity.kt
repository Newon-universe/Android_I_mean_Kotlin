package com.softsquared.template.kotlin.src.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityLoginBinding
import com.softsquared.template.kotlin.src.login.find_email.FindEmailFragment
import com.softsquared.template.kotlin.src.login.find_password.FindPasswordFragment
import com.softsquared.template.kotlin.src.login.models.PostLoginRequest
import com.softsquared.template.kotlin.src.login.models.ResponseLogin
import com.softsquared.template.kotlin.src.login.sign_up.SignUpFragment
import com.softsquared.template.kotlin.src.main.MainActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate), LoginActivityView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.myLoginToolbarBackArrow.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.myLoginButton.setOnClickListener{
            val email = binding.myLoginEmail.text.toString()
            val password = binding.myLoginPassword.text.toString()
            if(email != "" && password != ""){
                val postLoginRequest = PostLoginRequest(email = email, pwd = password)
                showLoadingDialog(this)
                LoginService(this).tryPostLogin(postLoginRequest)
            }
        }

        binding.myLoginFindEmail.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.my_login_frame_layout, FindEmailFragment())
                .commitAllowingStateLoss()
        }

        binding.myLoginFindPassword.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.my_login_frame_layout, FindPasswordFragment())
                .commitAllowingStateLoss()
        }

        binding.myLoginSignup.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.my_login_frame_layout, SignUpFragment())
                .commitAllowingStateLoss()
        }
    }


    override fun onPostLoginSuccess(response: ResponseLogin){
        dismissLoadingDialog()
        if(response.isSuccess){
            val jwt = ApplicationClass.sSharedPreferences.edit().putString(ApplicationClass.X_ACCESS_TOKEN, response.result.jwt)
            jwt.apply()
            MainActivity().jwtChecking()
            Log.d("why", "${ApplicationClass.sSharedPreferences.getString(ApplicationClass.X_ACCESS_TOKEN, "")}")
            finish()
        }
        response.message?.let { showCustomToast(it) }

    }

    override fun onPostLoginFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }
}