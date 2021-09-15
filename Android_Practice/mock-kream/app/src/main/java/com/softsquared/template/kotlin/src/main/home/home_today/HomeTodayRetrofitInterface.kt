package com.softsquared.template.kotlin.src.main.home.home_today

import com.softsquared.template.kotlin.src.main.home.home_today.models.ResponseHomeToday
import retrofit2.Call
import retrofit2.http.GET

interface HomeTodayRetrofitInterface {

    @GET("/today")
    fun getTodayInformation() : Call<ResponseHomeToday>


}