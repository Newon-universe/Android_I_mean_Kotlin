package com.softsquared.template.kotlin.src.login.find_email.find_email_result

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentFindEmailResultBinding

class FindEmailResultFragment : BaseFragment<FragmentFindEmailResultBinding>(FragmentFindEmailResultBinding::bind, R.layout.fragment_find_email_result) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val email = arguments?.getString("email")
        binding.findEmailResultEmailContent.setText(email)

        binding.myLoginFindEmailResultToolbarBackArrow.setOnClickListener {
            fragmentManager?.beginTransaction()?.remove(this)?.commitAllowingStateLoss()
        }

    }


}