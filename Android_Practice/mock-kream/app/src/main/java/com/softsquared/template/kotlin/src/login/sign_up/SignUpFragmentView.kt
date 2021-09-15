package com.softsquared.template.kotlin.src.login.sign_up

import com.softsquared.template.kotlin.src.login.sign_up.models.ResponsePostSignUp

interface SignUpFragmentView {

    fun onPostSignUpSuccess(response : ResponsePostSignUp)

    fun onPostSignUpFailure(message: String)

}