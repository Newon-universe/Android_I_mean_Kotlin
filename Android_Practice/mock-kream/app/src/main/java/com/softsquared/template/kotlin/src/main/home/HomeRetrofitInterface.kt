package com.softsquared.template.kotlin.src.main.home

import com.softsquared.template.kotlin.src.main.home.models.PostSignUpRequestTemplate
import com.softsquared.template.kotlin.src.main.home.models.SignUpResponse
import com.softsquared.template.kotlin.src.main.home.models.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface HomeRetrofitInterface {
    @GET("/users")
    fun getUsers() : Call<UserResponse>

    @POST("/users")
    fun postSignUp(@Body params: PostSignUpRequestTemplate): Call<SignUpResponse>
}
