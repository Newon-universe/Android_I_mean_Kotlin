package com.softsquared.template.kotlin.src.goods.final_buy

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.goods.final_buy.models.PostBuyFinalRequest
import com.softsquared.template.kotlin.src.goods.final_buy.models.ResponseBuyFinal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class BuyFinalService(val view:BuyFinalFragmentView) {

    fun tryPostBuyFinal(postBuyFinalRequest: PostBuyFinalRequest){
        val buyFinalRetrofitInterface = ApplicationClass.sRetrofit.create(BuyFinalRetrofitInterface::class.java)
        buyFinalRetrofitInterface.postBuyFinal(postBuyFinalRequest).enqueue(object : Callback<ResponseBuyFinal>{
            override fun onResponse(call: Call<ResponseBuyFinal>, response: Response<ResponseBuyFinal>) {
                view.onPostBuyGoodSuccess(response.body() as ResponseBuyFinal)
            }

            override fun onFailure(call: Call<ResponseBuyFinal>, t: Throwable) {
                view.onPostBuyGoodFailure(t.message?: "통신 오류")
            }
        })
    }
}