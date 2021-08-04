package com.example.thread_practice

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel
import io.github.controlwear.virtual.joystick.android.JoystickView

abstract class Missile(context: Context) : View(context) {

    var positionX : Float = 0F
    var positionY : Float = 0F

    fun missile(positionX: Float, positionY: Float){
        this.x= positionX
        this.y = positionY


    }




}