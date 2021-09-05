package com.softsquared.template.kotlin.src.main.shop

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.shop.models.ResponseShopTop
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class ShopService(val view: ShopFragmentView) {

    fun tryGetShopTop(){
        val shopRetrofitInterface = ApplicationClass.sRetrofit.create(ShopRetrofitInterface::class.java)
        shopRetrofitInterface.getShopTop().enqueue(object : Callback<ResponseShopTop>{
            override fun onResponse(call: Call<ResponseShopTop>, response: Response<ResponseShopTop>) {
                view.onGetShopTopSuccess(response.body() as ResponseShopTop)
            }

            override fun onFailure(call: Call<ResponseShopTop>, t: Throwable) {
                view.onGetShopTopFailure(t.message ?: "통신 오류")
            }

        })
    }

}