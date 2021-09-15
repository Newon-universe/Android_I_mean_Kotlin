package com.example.kakaologinpractice

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this, "fd9e729238743764c4f8a4c9ff83fb26")
    }
}