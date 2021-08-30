package com.softsquared.template.kotlin.src.main.my.myShop

import com.softsquared.template.kotlin.src.main.my.myShop.models.ResponseMyShop
import retrofit2.Call
import retrofit2.http.GET

interface MyShopRetrofitInterface {

    @GET("/my/all")
    fun getMy(): Call<ResponseMyShop>

}