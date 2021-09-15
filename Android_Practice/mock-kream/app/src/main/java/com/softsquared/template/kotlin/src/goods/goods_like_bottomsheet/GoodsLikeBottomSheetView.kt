package com.softsquared.template.kotlin.src.goods.goods_like_bottomsheet

import com.softsquared.template.kotlin.src.goods.goods_like_bottomsheet.models.ResponseGetGoodsLike
import com.softsquared.template.kotlin.src.goods.goods_like_bottomsheet.models.ResponsePatchGoodsLike
import com.softsquared.template.kotlin.src.goods.goods_like_bottomsheet.models.ResponsePostGoodsLike

interface GoodsLikeBottomSheetView {

    fun onPostGoodsLikeSuccess(response: ResponsePostGoodsLike)

    fun onPostGoodsLikeFailure(message: String)

    fun onPatchGoodsLikeSuccess(response: ResponsePatchGoodsLike)

    fun onPatchGoodsLikeFailure(message: String)

    fun onGetGoodsLikeSuccess(response: ResponseGetGoodsLike)

    fun onGetGoodsLikeFailure(message: String)

}