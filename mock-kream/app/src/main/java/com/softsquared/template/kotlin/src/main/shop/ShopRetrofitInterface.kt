package com.softsquared.template.kotlin.src.main.shop

import com.softsquared.template.kotlin.src.main.shop.models.ResponseShopTop
import retrofit2.Call
import retrofit2.http.GET

interface ShopRetrofitInterface {

    @GET("/shop/top")
    fun getShopTop(): Call<ResponseShopTop>

}