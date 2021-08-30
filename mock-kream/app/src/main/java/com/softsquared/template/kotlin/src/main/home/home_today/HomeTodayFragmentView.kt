package com.softsquared.template.kotlin.src.main.home.home_today

import com.softsquared.template.kotlin.src.main.home.home_today.models.ResponseHomeToday

interface HomeTodayFragmentView {

    fun onGetHomeTodayInformationSuccess(response: ResponseHomeToday)

    fun onGetHomeTodayInformationFailure(response: String)

}