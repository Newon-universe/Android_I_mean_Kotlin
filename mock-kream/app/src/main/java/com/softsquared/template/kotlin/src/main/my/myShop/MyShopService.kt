package com.softsquared.template.kotlin.src.main.my.myShop

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.my.myShop.models.ResponseMyShop
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyShopService(val view:MyShopFragmentView) {

    fun tryGetMyInformation(){
        val myShopRetrofitInterface = ApplicationClass.sRetrofit.create(MyShopRetrofitInterface::class.java)
        myShopRetrofitInterface.getMy().enqueue(object: Callback<ResponseMyShop> {
            override fun onResponse(call: Call<ResponseMyShop>, response: Response<ResponseMyShop>) {
                view.onGetMyShopInformationSuccess(response.body() as ResponseMyShop)
            }

            override fun onFailure(call: Call<ResponseMyShop>, t: Throwable) {
                view.onGetMyShopInformationFailure(t.message?:"통신 오류")
            }
        })

    }

}