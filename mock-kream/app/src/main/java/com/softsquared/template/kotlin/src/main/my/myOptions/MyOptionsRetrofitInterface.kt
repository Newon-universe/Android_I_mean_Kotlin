package com.softsquared.template.kotlin.src.main.my.myOptions

import com.softsquared.template.kotlin.config.BaseResponse
import retrofit2.Call
import retrofit2.http.DELETE

interface MyOptionsRetrofitInterface {

    @DELETE("/users/logout")
    fun deleteLogout() : Call<BaseResponse>


}