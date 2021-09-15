package com.softsquared.template.kotlin.src.goods.final_buy

import com.softsquared.template.kotlin.src.goods.final_buy.models.ResponseBuyFinal

interface BuyFinalFragmentView {

    fun onPostBuyGoodSuccess(response: ResponseBuyFinal)

    fun onPostBuyGoodFailure(message: String)

}