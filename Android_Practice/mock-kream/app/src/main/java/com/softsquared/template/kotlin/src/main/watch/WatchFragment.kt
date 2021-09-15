package com.softsquared.template.kotlin.src.main.watch

import android.os.Bundle
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentWatchBinding

class WatchFragment :  BaseFragment<FragmentWatchBinding>(FragmentWatchBinding::bind, R.layout.fragment_watch){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}