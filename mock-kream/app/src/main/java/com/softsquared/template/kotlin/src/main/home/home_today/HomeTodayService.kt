package com.softsquared.template.kotlin.src.main.home.home_today

import android.util.Log
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.main.home.home_today.models.ResponseHomeToday
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeTodayService(val view: HomeTodayFragmentView) {

    fun tryGetTodayInformation(){
        val homeTodayRetrofitInterface = ApplicationClass.sRetrofit.create(HomeTodayRetrofitInterface::class.java)
        homeTodayRetrofitInterface.getTodayInformation().enqueue(object : Callback<ResponseHomeToday>{
            override fun onResponse(call: Call<ResponseHomeToday>, response: Response<ResponseHomeToday>) {
                view.onGetHomeTodayInformationSuccess(response.body() as ResponseHomeToday)
            }

            override fun onFailure(call: Call<ResponseHomeToday>, t: Throwable) {
                view.onGetHomeTodayInformationFailure(t.message ?: "통신오류")
            }
        })
    }

}