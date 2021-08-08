package com.example.thread_practice

import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.animation.ValueAnimator


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import com.example.thread_practice.databinding.ActivityMainBinding
import io.github.controlwear.virtual.joystick.android.JoystickView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.log
import kotlin.math.sin
import kotlin.random.Random as Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val minute = binding.minute
        val second = binding.second
        with(Timer(this)) {
            timeThread(minute, second).isDaemon = true
            timeThread(minute, second).start()
        }

        val joystick = binding.joystick
        val player = binding.player
        val topMargin = binding.topMargin
        val playGround = binding.playGround
        JoyStick(this).joyStickCall(joystick, player, topMargin, playGround)


        val missile1 = binding.something1
        val missile2 = binding.something2
        val missile3 = binding.something3
        val missile4 = binding.something4
        with(Missile(this)){
            shooting(4, missile1, player, 2000)
            shooting(10, missile1, player, 2000)
            shooting(10, missile2, player, 2500)
            shooting(10, missile3, player, 3000)
            shooting(10, missile4, player, 3500)
            shooting(13, missile1, player, 2000)
            shooting(14, missile4, player, 2000)
            shooting(15, missile2, player, 2000)
            shooting(15, missile3, player, 2000)
        }


    }
}