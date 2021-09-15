package com.softsquared.template.kotlin.src.login

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.login.models.PostLoginRequest
import com.softsquared.template.kotlin.src.login.models.ResponseLogin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService(val view:LoginActivityView) {

    fun tryPostLogin(postLoginRequestSample: PostLoginRequest){
        val loginRetrofitInterface = ApplicationClass.sRetrofit.create(LoginRetrofitInterface::class.java)
        loginRetrofitInterface.postSignUp(postLoginRequestSample).enqueue(object: Callback<ResponseLogin>{
            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                view.onPostLoginSuccess(response.body() as ResponseLogin)
            }

            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                view.onPostLoginFailure(t.message?: "통신 오류")
            }
        })
    }


}