package com.softsquared.template.kotlin.src.goods

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.goods.models.ResponseGoods
import com.softsquared.template.kotlin.src.goods.models_immediately_buy.ResponseImmediatelyBuy
import com.softsquared.template.kotlin.src.goods.models_immediately_sell.ResponseImmediatelySell
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class GoodsMainService(val view:GoodsMainView) {

    fun tryGetGoodsMain(idx: Int){
        val goodsMainInterface = ApplicationClass.sRetrofit.create(GoodsRetrofitInterface::class.java)
        goodsMainInterface.getGoodsMain(idx).enqueue(object: Callback<ResponseGoods> {
            override fun onResponse(call: Call<ResponseGoods>, response: Response<ResponseGoods>) {
                view.onGetGoodsMainSuccess(response.body() as ResponseGoods)
            }

            override fun onFailure(call: Call<ResponseGoods>, t: Throwable) {
                view.onGetGoodsMainFailure(t.message?: "통신 오류")
            }
        })
    }

    fun tryGetImmediatelyBuy(goodsidx:Int){
        val goodsMainInterface = ApplicationClass.sRetrofit.create(GoodsRetrofitInterface::class.java)
        goodsMainInterface.getImmediatelyBuy(goodsidx).enqueue(object: Callback<ResponseImmediatelyBuy>{
            override fun onResponse(call: Call<ResponseImmediatelyBuy>, response: Response<ResponseImmediatelyBuy>) {
                view.onGetImmediatelyBuySuccess(response.body() as ResponseImmediatelyBuy)
            }

            override fun onFailure(call: Call<ResponseImmediatelyBuy>, t: Throwable) {
                view.onGetImmediatelyBuyFailure(t.message?: "통신 오류")
            }

        })
    }

    fun tryGetImmediatelySell(goodsidx:Int){
        val goodsMainInterface = ApplicationClass.sRetrofit.create(GoodsRetrofitInterface::class.java)
        goodsMainInterface.getImmediatelySell(goodsidx).enqueue(object: Callback<ResponseImmediatelySell>{
            override fun onResponse(call: Call<ResponseImmediatelySell>, response: Response<ResponseImmediatelySell>) {
                view.onGetImmediatelySellSuccess(response.body() as ResponseImmediatelySell)
            }
            override fun onFailure(call: Call<ResponseImmediatelySell>, t: Throwable) {
                view.onGetImmediatelySellFailure(t.message?: "통신 오류")
            }
        })
    }

}