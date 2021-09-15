package com.softsquared.template.kotlin.src.login.find_email

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentFindEmailBinding
import com.softsquared.template.kotlin.src.login.LoginActivity
import com.softsquared.template.kotlin.src.login.find_email.find_email_result.FindEmailResultFragment
import com.softsquared.template.kotlin.src.login.find_email.models.PostFindEmailbyPhoneRequest
import com.softsquared.template.kotlin.src.login.find_email.models.ResponseFindEmail
import com.softsquared.template.kotlin.src.login.find_email.models.Result


class FindEmailFragment : BaseFragment<FragmentFindEmailBinding>(FragmentFindEmailBinding::bind, R.layout.fragment_find_email), FindEmailFragmentView {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myLoginFindEmailToolbarBackArrow.setOnClickListener {
            fragmentManager?.beginTransaction()?.remove(this)?.commit()
        }

        binding.findEmailBtn.setOnClickListener {
            val phone = binding.findEmailPhoneNumberEditTv.text.toString()
            val postFindEmailbyPhoneRequest = PostFindEmailbyPhoneRequest(phone = phone)
            showLoadingDialog(requireActivity())
            FindEmailService(this).tryPostFindEmailbyPhone(postFindEmailbyPhoneRequest)
        }

    }




    override fun onPostFindEmailSuccess(response: ResponseFindEmail) {
        dismissLoadingDialog()
        response.message?.let { showCustomToast(it) }
        val responseEmail = response.result.email
        Log.d("why", "$responseEmail")

        if(responseEmail != null){
            val bundle = Bundle()
            bundle.putString("email", responseEmail)


        }

    }

    override fun onPostFindEmailFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }

}