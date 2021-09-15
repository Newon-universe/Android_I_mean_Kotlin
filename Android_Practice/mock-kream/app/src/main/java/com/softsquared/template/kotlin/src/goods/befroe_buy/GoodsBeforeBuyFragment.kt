package com.softsquared.template.kotlin.src.goods.befroe_buy

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentBeforeBuyNotificationBinding
import com.softsquared.template.kotlin.databinding.FragmentBeforeSellNotificationBinding
import com.softsquared.template.kotlin.src.goods.final_buy.BuyFinalFragment

class GoodsBeforeBuyFragment:BaseFragment<FragmentBeforeBuyNotificationBinding>(FragmentBeforeBuyNotificationBinding::bind, R.layout.fragment_before_buy_notification) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.goodsBeforeBuyCheck4.setOnClickListener {
            binding.goodsBeforeBuyBtn.setBackgroundColor(Color.parseColor("#000000"))
            binding.goodsBeforeBuyBtn.setTextColor(Color.parseColor("#ffffff"))

        }

        binding.goodsBeforeBuyBtn.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.goods_before_frame_layout, BuyFinalFragment())
                .commitAllowingStateLoss()
        }
    }

}