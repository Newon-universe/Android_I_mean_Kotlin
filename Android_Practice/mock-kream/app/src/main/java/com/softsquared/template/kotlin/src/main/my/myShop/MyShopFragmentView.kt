package com.softsquared.template.kotlin.src.main.my.myShop

import com.softsquared.template.kotlin.src.main.my.myShop.models.ResponseMyShop

interface MyShopFragmentView {

    fun onGetMyShopInformationSuccess(response: ResponseMyShop)

    fun onGetMyShopInformationFailure(message: String)

}