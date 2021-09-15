package com.softsquared.template.kotlin.src.goods.goods_like_bottomsheet

import com.softsquared.template.kotlin.src.goods.goods_like_bottomsheet.models.ResponseGetGoodsLike
import com.softsquared.template.kotlin.src.goods.goods_like_bottomsheet.models.ResponsePatchGoodsLike
import com.softsquared.template.kotlin.src.goods.goods_like_bottomsheet.models.ResponsePostGoodsLike
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface GoodsLikeBottomRetrofitInterface {

    @POST("/like/{goodsidx}/{size}")
    fun postGoodsLike(@Path("goodsidx") idx:Int, @Path("size") size:Int) : Call<ResponsePostGoodsLike>

    @PATCH("/like/{goodsidx}/{size}")
    fun patchGoodsLike(@Path("goodsidx") idx:Int, @Path("size") size:Int) : Call<ResponsePatchGoodsLike>

    @GET("/like/{goodsidx}")
    fun getGoodsLike(@Path("goodsidx") idx:Int) : Call<ResponseGetGoodsLike>

}