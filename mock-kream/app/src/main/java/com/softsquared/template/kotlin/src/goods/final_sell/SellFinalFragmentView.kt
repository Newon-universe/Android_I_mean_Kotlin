package com.softsquared.template.kotlin.src.goods.final_sell

import com.softsquared.template.kotlin.src.goods.final_sell.models.ResponseSellFinal

interface SellFinalFragmentView {

    fun onPostSellGoodSuccess(response: ResponseSellFinal)

    fun onPostSellGoodFailure(message: String)

}