package com.softsquared.template.kotlin.src.login.sign_up.models

import com.google.gson.annotations.SerializedName

data class PostSignUpRequest (
    @SerializedName("email") val email: String,
    @SerializedName("pwd") val pwd: String,
    @SerializedName("shoessize") val shoessize: String,
    @SerializedName("adreceive") val adreceive: String?,
    @SerializedName("phone") val phone: String
    )