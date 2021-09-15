package com.softsquared.template.kotlin.src.login

import com.softsquared.template.kotlin.src.login.models.PostLoginRequest
import com.softsquared.template.kotlin.src.login.models.ResponseLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRetrofitInterface {

    @POST("/users/login")
    fun postSignUp(@Body params: PostLoginRequest): Call<ResponseLogin>

}