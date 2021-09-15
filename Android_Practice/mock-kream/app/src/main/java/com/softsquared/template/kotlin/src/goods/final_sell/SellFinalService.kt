package com.softsquared.template.kotlin.src.goods.final_sell

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.goods.final_sell.models.PostSellFinalRequest
import com.softsquared.template.kotlin.src.goods.final_sell.models.ResponseSellFinal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SellFinalService(val view:SellFinalFragmentView){

    fun tryPostSellFinal(postSellFinalRequest: PostSellFinalRequest){
        val postSellFinalRetrofitInterface = ApplicationClass.sRetrofit.create(SellFinalRetrofitInterface::class.java)
        postSellFinalRetrofitInterface.postSellFinal(postSellFinalRequest).enqueue(object: Callback<ResponseSellFinal> {
            override fun onResponse(call: Call<ResponseSellFinal>, response: Response<ResponseSellFinal>) {
                view.onPostSellGoodSuccess(response.body() as ResponseSellFinal)
            }

            override fun onFailure(call: Call<ResponseSellFinal>, t: Throwable) {
                view.onPostSellGoodFailure(t.message?: "통신 오류")
            }
        })
    }

}