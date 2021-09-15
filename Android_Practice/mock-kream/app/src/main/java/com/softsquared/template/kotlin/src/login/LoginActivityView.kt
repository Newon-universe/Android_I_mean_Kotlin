package com.softsquared.template.kotlin.src.login

import com.softsquared.template.kotlin.src.login.models.ResponseLogin

interface LoginActivityView {

   fun onPostLoginSuccess(response: ResponseLogin)

   fun onPostLoginFailure(message: String)



}