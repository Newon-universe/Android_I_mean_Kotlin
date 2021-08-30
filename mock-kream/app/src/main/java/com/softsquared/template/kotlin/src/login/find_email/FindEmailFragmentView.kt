package com.softsquared.template.kotlin.src.login.find_email

import com.softsquared.template.kotlin.src.login.find_email.models.ResponseFindEmail


interface FindEmailFragmentView {

    fun onPostFindEmailSuccess(response: ResponseFindEmail)

    fun onPostFindEmailFailure(message: String)
}