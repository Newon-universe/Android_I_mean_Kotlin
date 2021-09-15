package com.softsquared.template.kotlin.src.goods

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentGoodsMainBuySellBinding
import com.softsquared.template.kotlin.databinding.FragmentGoodsMainBuySellRecyclerviewItmesBinding

data class GoodsBottomSheetInformation(val size: String, val price: String)

class GoodsBottomSheetFragment(private val goodsMainSizePrice:(MutableList<String>)-> Unit):BottomSheetDialogFragment(){

    private var goodsBottomSheetInformation:MutableList<GoodsBottomSheetInformation> = mutableListOf()
    private lateinit var binding : FragmentGoodsMainBuySellBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGoodsMainBuySellBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        getGoodsBottomSheetInformation()
        binding.goodsBottomSheetSizeRecyclerview.layoutManager = GridLayoutManager(activity, 2)
        binding.goodsBottomSheetSizeRecyclerview.adapter = GoodsBottomSheetAdapter(goodsBottomSheetInformation, goodsMainSizePrice, dialog)


        binding.goodsBottomSheetCloseBtn.setOnClickListener{
            dialog?.dismiss()
        }

    }

    private fun getGoodsBottomSheetInformation(){
        with(goodsBottomSheetInformation){
            add(
                GoodsBottomSheetInformation(
                    "모든 사이즈", "-")
            )

            add(
                GoodsBottomSheetInformation(
                    "230",
                    "1,495,000원")
            )
            add(
                GoodsBottomSheetInformation(
                    "240",
                    "1,399,000원")
            )
            add(
                GoodsBottomSheetInformation(
                    "250",
                    "1,462,000원")
            )
            add(
                GoodsBottomSheetInformation(
                    "260",
                    "1,564,000원")
            )
            add(
                GoodsBottomSheetInformation(
                    "270",
                    "1,564,000원")
            )
            add(
                GoodsBottomSheetInformation(
                    "280",
                    "1,860,000원")
            )
        }
    }

}