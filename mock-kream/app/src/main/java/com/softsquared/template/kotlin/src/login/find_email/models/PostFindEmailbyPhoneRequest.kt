package com.softsquared.template.kotlin.src.login.find_email.models

import com.google.gson.annotations.SerializedName

data class PostFindEmailbyPhoneRequest(
    @SerializedName("phone") val phone:String
)
