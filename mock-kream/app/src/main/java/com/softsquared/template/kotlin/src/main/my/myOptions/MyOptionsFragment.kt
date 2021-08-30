package com.softsquared.template.kotlin.src.main.my.myOptions

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentGoodsMainBuySellBinding
import com.softsquared.template.kotlin.databinding.FragmentMyShopOptionsBinding
import com.softsquared.template.kotlin.src.goods.GoodsBottomSheetInformation
import com.softsquared.template.kotlin.src.main.MainActivity

class MyOptionsFragment:BottomSheetDialogFragment() {

    private lateinit var binding : FragmentMyShopOptionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyShopOptionsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.myShopOptionsLogout.setOnClickListener {
            val logout = ApplicationClass.sSharedPreferences.edit().remove(ApplicationClass.X_ACCESS_TOKEN)
            logout.apply()
            MainActivity().jwtChecking()
        }
    }

}