package com.softsquared.template.kotlin.src.main.shop

import android.os.Bundle
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentShopBinding

class ShopFragment : BaseFragment<FragmentShopBinding>(FragmentShopBinding::bind, R.layout.fragment_shop) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}

