package com.softsquared.template.kotlin.src.goods.goods_like_bottomsheet

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentGoodsMainLikeBinding
import com.softsquared.template.kotlin.src.goods.goods_like_bottomsheet.models.ResponseGetGoodsLike
import com.softsquared.template.kotlin.src.goods.goods_like_bottomsheet.models.ResponsePatchGoodsLike
import com.softsquared.template.kotlin.src.goods.goods_like_bottomsheet.models.ResponsePostGoodsLike

data class GoodsLikeBottomSheetInformation(val size: String, var interest: Boolean = false)

class GoodsLikeBottomSheetFragment(val idx:Int):BottomSheetDialogFragment(), GoodsLikeBottomSheetView {

    private var goodsLikeBottomSheetInformation:MutableList<GoodsLikeBottomSheetInformation> = mutableListOf()
    private lateinit var binding : FragmentGoodsMainLikeBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGoodsMainLikeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.goodsBottomLikeSheetCloseBtn.setOnClickListener {
            dialog?.dismiss()
        }

        GoodsLikeBottomService(this).tryGetGoodsLike(idx)



    }

    private fun getGoodsLikeSheetInformation() {
        with(goodsLikeBottomSheetInformation) {
            add(GoodsLikeBottomSheetInformation("230"))
            add(GoodsLikeBottomSheetInformation("235(US 4.5)"))
            add(GoodsLikeBottomSheetInformation("235(US 5)"))
            add(GoodsLikeBottomSheetInformation("240(US 5.5)"))
            add(GoodsLikeBottomSheetInformation("240(US 6)"))
            add(GoodsLikeBottomSheetInformation("245"))
            add(GoodsLikeBottomSheetInformation("250"))
            add(GoodsLikeBottomSheetInformation("255"))
            add(GoodsLikeBottomSheetInformation("260"))
            add(GoodsLikeBottomSheetInformation("265"))
            add(GoodsLikeBottomSheetInformation("270"))
            add(GoodsLikeBottomSheetInformation("275"))
            add(GoodsLikeBottomSheetInformation("280"))
            add(GoodsLikeBottomSheetInformation("285"))
            add(GoodsLikeBottomSheetInformation("290"))
            add(GoodsLikeBottomSheetInformation("295"))
            add(GoodsLikeBottomSheetInformation("300"))
            add(GoodsLikeBottomSheetInformation("305"))
            add(GoodsLikeBottomSheetInformation("310"))
            add(GoodsLikeBottomSheetInformation("315"))
            add(GoodsLikeBottomSheetInformation("320"))
        }
    }

    override fun onPostGoodsLikeSuccess(response: ResponsePostGoodsLike) {
        if(response.message != null)
            showCustomToast(response.message!!)
    }

    override fun onPostGoodsLikeFailure(message: String) {
        showCustomToast(message)
    }

    override fun onPatchGoodsLikeSuccess(response: ResponsePatchGoodsLike) {
        if(response.message != null)
            showCustomToast(response.message!!)
    }

    override fun onPatchGoodsLikeFailure(message: String) {
        showCustomToast(message)
    }

    override fun onGetGoodsLikeSuccess(response: ResponseGetGoodsLike) {
        if(response.message != null)
            showCustomToast(response.message!!)
        if(response.isSuccess){
            val likedSize = response.result
            showCustomToast(likedSize.toString())


            getGoodsLikeSheetInformation()
            for(wantSize in likedSize.toString()){
                var i = 0
                i++

                for(theSize in goodsLikeBottomSheetInformation){
                    var j = 0
                    j++
                    if(wantSize.toString() == theSize.toString()){
                        goodsLikeBottomSheetInformation.set(j, GoodsLikeBottomSheetInformation(size = theSize.toString(),interest = true))
                    }
                }
            }
            binding.goodsBottomSheetSizeRecyclerview.layoutManager = GridLayoutManager(activity, 2)
            binding.goodsBottomSheetSizeRecyclerview.adapter = GoodsLikeBottomSheetAdapter(goodsLikeBottomSheetInformation, ({
                GoodsLikeBottomService(this).tryPostGoodsLike(idx, it)
            }), ({
                GoodsLikeBottomService(this).tryPatchGoodsLike(idx, it)
            }), likedSize
            )

        }
    }

    override fun onGetGoodsLikeFailure(message: String) {
        showCustomToast(message)
    }


    fun showCustomToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }
}