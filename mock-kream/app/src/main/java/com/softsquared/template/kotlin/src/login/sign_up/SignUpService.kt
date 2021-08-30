package com.softsquared.template.kotlin.src.login.sign_up

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.login.sign_up.models.PostSignUpRequest
import com.softsquared.template.kotlin.src.login.sign_up.models.ResponsePostSignUp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class SignUpService(val view:SignUpFragmentView) {

    fun tryPostSignUp(postSignUpRequest: PostSignUpRequest){
        val signUpRetrofitInterface = ApplicationClass.sRetrofit.create(SignUpRetrofitInterface::class.java)
        signUpRetrofitInterface.postSignUp(postSignUpRequest).enqueue(object : Callback<ResponsePostSignUp>{
            override fun onResponse(call: Call<ResponsePostSignUp>, response: Response<ResponsePostSignUp>) {
                view.onPostSignUpSuccess(response.body() as ResponsePostSignUp)
            }

            override fun onFailure(call: Call<ResponsePostSignUp>, t: Throwable) {
                view.onPostSignUpFailure(t.message?: "통신 오류")
            }
        })

    }
}