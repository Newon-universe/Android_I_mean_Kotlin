package com.softsquared.template.kotlin.src.main.style

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentStyleBinding

class StyleFragment : BaseFragment<FragmentStyleBinding>(FragmentStyleBinding::bind, R.layout.fragment_style){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}