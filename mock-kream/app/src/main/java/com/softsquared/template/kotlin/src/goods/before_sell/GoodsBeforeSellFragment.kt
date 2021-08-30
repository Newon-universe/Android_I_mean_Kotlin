package com.softsquared.template.kotlin.src.goods.before_sell

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentBeforeSellNotificationBinding
import com.softsquared.template.kotlin.databinding.FragmentGoodsMainBuySellBinding
import com.softsquared.template.kotlin.src.goods.befroe_buy.GoodsBeforeBuyFragment
import com.softsquared.template.kotlin.src.goods.final_sell.SellFinalFragment

class GoodsBeforeSellFragment:BaseFragment<FragmentBeforeSellNotificationBinding>(FragmentBeforeSellNotificationBinding::bind, R.layout.fragment_before_sell_notification){

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.goodsBeforeSellCheck5.setOnClickListener {
            binding.goodsBeforeSellBtn.setBackgroundColor(Color.parseColor("#000000"))
            binding.goodsBeforeSellBtn.setTextColor(Color.parseColor("#ffffff"))

        }

        binding.goodsBeforeSellBtn.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.goods_before_frame_layout, SellFinalFragment())
                .commitAllowingStateLoss()
        }

    }
}