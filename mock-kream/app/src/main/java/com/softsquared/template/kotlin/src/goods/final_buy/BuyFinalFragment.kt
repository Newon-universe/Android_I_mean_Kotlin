package com.softsquared.template.kotlin.src.goods.final_buy

import android.os.Bundle
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentFinalBuyBinding
import com.softsquared.template.kotlin.src.goods.final_buy.models.PostBuyFinalRequest
import com.softsquared.template.kotlin.src.goods.final_buy.models.ResponseBuyFinal


class BuyFinalFragment : BaseFragment<FragmentFinalBuyBinding>(FragmentFinalBuyBinding::bind, R.layout.fragment_final_buy), BuyFinalFragmentView{

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.finalBuyBtn.setOnClickListener {
            val postBuyFinalRequest = PostBuyFinalRequest(
                goodsidx = 1, size = 220, price = 132000
            )
            BuyFinalService(this).tryPostBuyFinal(postBuyFinalRequest)
        }

    }


    override fun onPostBuyGoodSuccess(response: ResponseBuyFinal) {
        showCustomToast(response.message)
    }

    override fun onPostBuyGoodFailure(message: String) {
        showCustomToast(message)
    }

}