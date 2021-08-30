package com.softsquared.template.kotlin.src.goods.goods_like_bottomsheet

import android.util.Log
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.goods.goods_like_bottomsheet.models.ResponseGetGoodsLike
import com.softsquared.template.kotlin.src.goods.goods_like_bottomsheet.models.ResponsePatchGoodsLike
import com.softsquared.template.kotlin.src.goods.goods_like_bottomsheet.models.ResponsePostGoodsLike
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class GoodsLikeBottomService(val view:GoodsLikeBottomSheetView) {

    fun tryPostGoodsLike(goodsidx:Int, size:Int){
        val goodsLikeBottomRetrofitInterface = ApplicationClass.sRetrofit.create(GoodsLikeBottomRetrofitInterface::class.java)
        goodsLikeBottomRetrofitInterface.postGoodsLike(goodsidx, size).enqueue(object : Callback<ResponsePostGoodsLike>{
            override fun onResponse(call: Call<ResponsePostGoodsLike>, response: Response<ResponsePostGoodsLike>) {
                view.onPostGoodsLikeSuccess(response.body() as ResponsePostGoodsLike)
            }

            override fun onFailure(call: Call<ResponsePostGoodsLike>, t: Throwable) {
                view.onPostGoodsLikeFailure(t.message?:"통신 오류")
            }
        })
    }

    fun tryPatchGoodsLike(goodsidx: Int, size:Int){
        val goodsLikeBottomRetrofitInterface = ApplicationClass.sRetrofit.create(GoodsLikeBottomRetrofitInterface::class.java)
        goodsLikeBottomRetrofitInterface.patchGoodsLike(goodsidx, size).enqueue(object : Callback<ResponsePatchGoodsLike>{
            override fun onResponse(call: Call<ResponsePatchGoodsLike>, response: Response<ResponsePatchGoodsLike>) {
                view.onPatchGoodsLikeSuccess(response.body() as ResponsePatchGoodsLike)
            }

            override fun onFailure(call: Call<ResponsePatchGoodsLike>, t: Throwable) {
                view.onPatchGoodsLikeFailure(t.message?:"통신 오류")
            }
        })
    }

    fun tryGetGoodsLike(goodsidx: Int){
        val goodsLikeBottomRetrofitInterface = ApplicationClass.sRetrofit.create(GoodsLikeBottomRetrofitInterface::class.java)
        goodsLikeBottomRetrofitInterface.getGoodsLike(goodsidx).enqueue(object : Callback<ResponseGetGoodsLike>{
            override fun onResponse(call: Call<ResponseGetGoodsLike>, response: Response<ResponseGetGoodsLike>) {
                view.onGetGoodsLikeSuccess(response.body() as ResponseGetGoodsLike)
            }

            override fun onFailure(call: Call<ResponseGetGoodsLike>, t: Throwable) {
                view.onGetGoodsLikeFailure(t.message?:"통신 오류")
            }
        })
    }



}