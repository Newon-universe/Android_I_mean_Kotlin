package com.softsquared.template.kotlin.src.main.my.myShop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentMyMainBinding
import com.softsquared.template.kotlin.databinding.FragmentMyProfileBinding
import com.softsquared.template.kotlin.databinding.FragmentMyShopBinding
import com.softsquared.template.kotlin.src.main.my.MyMainPagerFragmentAdapter
import com.softsquared.template.kotlin.src.main.my.myShop.models.ResponseMyShop

class MyShopFragment : BaseFragment<FragmentMyShopBinding>(FragmentMyShopBinding::bind, R.layout.fragment_my_shop), MyShopFragmentView {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MyShopService(this).tryGetMyInformation()

    }

    override fun onGetMyShopInformationSuccess(response: ResponseMyShop) {

        showCustomToast(response.message)

        if(response.isSuccess){
            Glide.with(requireContext())
                .load(response.result.profileimg)
                .into(binding.myShopProfileImg)

            binding.myShopProfileNickname.text = response.result.profilename
            binding.myShopProfileId.text = response.result.name
            binding.myShopGradeTv.text = response.result.grade
            binding.myShopPointTv.text = response.result.point
            binding.myShopInterestTv.text = response.result.like.toString()
            binding.myShopBuyRecordTotalTv.text = (response.result.buy.bid + response.result.buy.trading + response.result.buy.end).toString()
            binding.myShopBuyRecordBiddingTv.text = response.result.buy.bid.toString()
            binding.myShopBuyRecordProgressingTv.text = response.result.buy.trading.toString()
            binding.myShopBuyRecordDoneTv.text = response.result.buy.end.toString()
            binding.myShopSellRecordTotalTv.text = (response.result.sell.bid + response.result.sell.trading + response.result.sell.end).toString()
            binding.myShopSellRecordBiddingTv.text = response.result.sell.bid.toString()
            binding.myShopSellRecordProgressingTv.text = response.result.sell.trading.toString()
            binding.myShopSellRecordDoneTv.text = response.result.sell.end.toString()
            binding.myShopHoldingCount.text = response.result.mygoods.count.toString()
            binding.myShopHoldingYield.text = response.result.mygoods.total_profit_rate.toString()
            binding.myShopHoldingBoughtPrice.text = response.result.mygoods.buy_price_all.toString()
            binding.myShopHoldingValuationPL.text = response.result.mygoods.total_profit.toString()
        }

    }

    override fun onGetMyShopInformationFailure(message: String) {
    }
}