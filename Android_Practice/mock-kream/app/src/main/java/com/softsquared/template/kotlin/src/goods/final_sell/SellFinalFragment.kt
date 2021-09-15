package com.softsquared.template.kotlin.src.goods.final_sell

import android.os.Bundle
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentFinalSellBinding
import com.softsquared.template.kotlin.src.goods.final_sell.models.PostSellFinalRequest
import com.softsquared.template.kotlin.src.goods.final_sell.models.ResponseSellFinal

class SellFinalFragment : BaseFragment<FragmentFinalSellBinding>(FragmentFinalSellBinding::bind, R.layout.fragment_final_sell), SellFinalFragmentView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.finalSellBtn.setOnClickListener {
            val postSellFinalRequest = PostSellFinalRequest(
                goodsidx = 1, size = 220)
            SellFinalService(this).tryPostSellFinal(postSellFinalRequest)
        }
    }

    override fun onPostSellGoodSuccess(response: ResponseSellFinal) {
        showCustomToast(response.message)
    }

    override fun onPostSellGoodFailure(message: String) {
        showCustomToast(message)
    }

}