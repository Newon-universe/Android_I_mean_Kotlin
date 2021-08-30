package com.softsquared.template.kotlin.src.login.find_email.models

import com.softsquared.template.kotlin.src.login.models.ResponseLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface FindEmailRetrofitInterface {

    @POST("/users/find-email")
    fun postFindEmailbyPhone(@Body params: PostFindEmailbyPhoneRequest): Call<ResponseFindEmail>

}