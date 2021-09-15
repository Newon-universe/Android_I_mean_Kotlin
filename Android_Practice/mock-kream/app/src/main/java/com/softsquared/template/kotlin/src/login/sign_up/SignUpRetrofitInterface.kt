package com.softsquared.template.kotlin.src.login.sign_up

import com.softsquared.template.kotlin.src.login.sign_up.models.PostSignUpRequest
import com.softsquared.template.kotlin.src.login.sign_up.models.ResponsePostSignUp
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpRetrofitInterface {

    @POST("/users/signup")
    fun postSignUp(@Body params: PostSignUpRequest) : Call<ResponsePostSignUp>


}