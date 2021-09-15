package com.softsquared.template.kotlin.src.main.shop

import com.softsquared.template.kotlin.src.main.shop.models.ResponseShopTop

interface ShopFragmentView {

    fun onGetShopTopSuccess(response: ResponseShopTop)

    fun onGetShopTopFailure(response : String)

}