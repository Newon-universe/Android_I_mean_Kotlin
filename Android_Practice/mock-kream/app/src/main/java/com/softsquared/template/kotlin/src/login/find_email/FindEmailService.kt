package com.softsquared.template.kotlin.src.login.find_email

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.login.find_email.models.FindEmailRetrofitInterface
import com.softsquared.template.kotlin.src.login.find_email.models.PostFindEmailbyPhoneRequest
import com.softsquared.template.kotlin.src.login.find_email.models.ResponseFindEmail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class FindEmailService(val view:FindEmailFragmentView) {

    fun tryPostFindEmailbyPhone(postFindEmailbyPhoneRequest: PostFindEmailbyPhoneRequest){
        val findEmailRetrofitInterface = ApplicationClass.sRetrofit.create(FindEmailRetrofitInterface::class.java)
        findEmailRetrofitInterface.postFindEmailbyPhone(postFindEmailbyPhoneRequest).enqueue(object: Callback<ResponseFindEmail>{
            override fun onResponse(call: Call<ResponseFindEmail>, response: Response<ResponseFindEmail>) {
                view.onPostFindEmailSuccess(response.body() as ResponseFindEmail)
            }

            override fun onFailure(call: Call<ResponseFindEmail>, t: Throwable) {
                view.onPostFindEmailFailure(t.message?: "통신 오류")
            }
        })
    }

}