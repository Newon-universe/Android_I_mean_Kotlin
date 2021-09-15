package com.softsquared.template.kotlin.src.login.sign_up

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.softsquared.template.kotlin.databinding.FragmentSignupShoesSizeBottomsheetBinding
import com.softsquared.template.kotlin.src.goods.GoodsBottomSheetInformation

class SignUpBottomSheetFragment(val sizeFix:(String)-> Unit): BottomSheetDialogFragment() {

    private lateinit var binding : FragmentSignupShoesSizeBottomsheetBinding
    private var signupSizeInformation:MutableList<String> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupShoesSizeBottomsheetBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.goodsBottomSheetCloseBtn.setOnClickListener{
            dialog?.dismiss()
        }

        getSignupSizeInformation()
        binding.goodsBottomSheetSizeRecyclerview.layoutManager = GridLayoutManager(activity, 3)
        binding.goodsBottomSheetSizeRecyclerview.adapter = SignUpBottomSheetAdapter(signupSizeInformation, dialog, sizeFix)

    }


    private fun getSignupSizeInformation(){
        with(signupSizeInformation){
            add("220")
            add("225")
            add("230")
            add("235")
            add("240")
            add("245")
            add("250")
            add("255")
            add("260")
            add("265")
            add("270")
            add("275")
            add("280")
            add("285")
            add("290")
            add("295")
            add("300")
        }
    }




}