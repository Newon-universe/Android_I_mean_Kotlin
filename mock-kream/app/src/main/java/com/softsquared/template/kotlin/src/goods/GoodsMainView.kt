package com.softsquared.template.kotlin.src.goods

import com.softsquared.template.kotlin.src.goods.models.ResponseGoods
import com.softsquared.template.kotlin.src.goods.models_immediately_buy.ResponseImmediatelyBuy
import com.softsquared.template.kotlin.src.goods.models_immediately_sell.ResponseImmediatelySell

interface GoodsMainView {

    fun onGetGoodsMainSuccess(response: ResponseGoods)

    fun onGetGoodsMainFailure(message: String)

    fun onGetImmediatelyBuySuccess(response: ResponseImmediatelyBuy)

    fun onGetImmediatelyBuyFailure(message: String)

    fun onGetImmediatelySellSuccess(response: ResponseImmediatelySell)

    fun onGetImmediatelySellFailure(message: String)

}