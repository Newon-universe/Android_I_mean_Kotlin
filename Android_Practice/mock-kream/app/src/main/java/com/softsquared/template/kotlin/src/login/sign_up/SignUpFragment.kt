package com.softsquared.template.kotlin.src.login.sign_up

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.green
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentSignUpBinding
import com.softsquared.template.kotlin.databinding.FragmentSignupShoesSizeBottomsheetBinding
import com.softsquared.template.kotlin.src.goods.GoodsBottomSheetFragment
import com.softsquared.template.kotlin.src.login.LoginActivity
import com.softsquared.template.kotlin.src.login.sign_up.models.PostSignUpRequest
import com.softsquared.template.kotlin.src.login.sign_up.models.ResponsePostSignUp
import com.softsquared.template.kotlin.src.main.MainActivity
import kotlin.random.Random

class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::bind, R.layout.fragment_sign_up), SignUpFragmentView {

    lateinit var adrecieve:String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signupSneakersSizeTv.setOnClickListener {
            val bottomSheet = SignUpBottomSheetFragment({
                binding.signupSneakersSizeTv.text = it
            })
            bottomSheet.show(childFragmentManager, bottomSheet.tag)
        }


        binding.signupMandatoryPolicyAgreement.setOnClickListener {
            if(binding.signupMandatoryPolicyAgreement.isChecked){
                binding.signupBtn.setBackgroundResource(R.drawable.shape_black_solid_rounded_corner)
                binding.signupBtn.setTextColor(Color.parseColor("#ffffff"))
            }
            else{
                binding.signupBtn.background
                binding.signupBtn.setBackgroundResource(R.color.my_profile_person_default_color)
                binding.signupBtn.setTextColor(Color.parseColor("#F1F1F1"))
            }
        }


        binding.signupBtn.setOnClickListener {
            showLoadingDialog(requireContext())
            if(!binding.signupNonmandatoryPolicyAgreement.isChecked){
                adrecieve = "{'app':1,'message':0,'mail':0}"
            }
            else if(binding.signupNonmandatoryPolicyAgreement.isChecked){
                adrecieve = "{'app':1,'message':1,'mail':1}"
            }

            val email = binding.signupEmailEditTv.text.toString()
            val pwd = binding.signupPasswordEditTv.text.toString()
            val shoessize = binding.signupSneakersSizeTv.text.toString()
            val phone = "010-${Random.nextInt(1000, 9999)}-${Random.nextInt(1000,9999)}"
            Log.d("why", "$phone")
            val postSignUpRequest = PostSignUpRequest(
                email = email, pwd = pwd, shoessize = shoessize, adreceive = adrecieve, phone = phone
            )
            Log.d("why", "$postSignUpRequest")
            SignUpService(this).tryPostSignUp(postSignUpRequest)
        }
    }



// for Retrofit, I didn`t connect with recyclerview not yet

    override fun onPostSignUpSuccess(response: ResponsePostSignUp) {
        dismissLoadingDialog()
        showCustomToast(response.message)
        if(response.isSuccess)
            childFragmentManager.beginTransaction().remove(SignUpFragment()).commitAllowingStateLoss()
    }

    override fun onPostSignUpFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast(message)
    }

}