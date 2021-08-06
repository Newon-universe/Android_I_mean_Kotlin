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

    private val TAG = "조이스틱"

    var handler: Handler = Handler()
    var runnable: Runnable = Runnable {  }


    var selectedView: ImageView? = null


    var checker: Int = 90

//    lateinit var g_playerLoc:IntArray
//    lateinit var g_somethingLoc:IntArray


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val timer = time(500, 2500).toLong()

        val minute = binding.minute
        val second = binding.second
        with(Timer(this)){
            timeThread(minute, second).isDaemon = true
            timeThread(minute, second).start()
        }

        val joystick = binding.joystick
        val player = binding.player
        val topMargin = binding.topMargin
        val playGround = binding.playGround
        JoyStick(this).joyStickCall(joystick, player, topMargin, playGround)





        val shooterThread = Thread(){
            while(checker >= 0){
                Thread.sleep(1000)
                checker--
                if(checker % 4 == 0){
                    handler.post {
                        somethingMove(binding.something1, binding.player, -2000f, 3000)
                        if (binding.something1.x <= 1000f){
                            binding.something1.x = 1780F
                            binding.something1.visibility = View.VISIBLE
                        }
                    }
                    Log.d(TAG, "checker : $checker")
                }
            }
        }
        shooterThread.isDaemon = true
        shooterThread.start()


//        while(checker >= 0) {
//            if (checker % 4 == 0) {
//                somethingMove(binding.something1, binding.player, -2000f, 3000)
//                if (binding.something1.x <= 1000f) {
//                    binding.something1.x = 1780F
//                    Log.d(TAG, "checker : $checker")
//                }
//            }
//            checker--
//        }


    }


    fun somethingMove(something: ImageView, playerView:ImageView,posix: Float, duration1: Long) {

        var animation: ObjectAnimator
        val moveThread: Thread

        moveThread = Thread(){
            handler.post{
                animation = ObjectAnimator.ofFloat(something, "translationX", posix).apply {
                    duration = duration1
                    interpolator = LinearInterpolator()
                    start()
                }
                animation.addUpdateListener(ValueAnimator.AnimatorUpdateListener(){
                    if(crash(something, playerView)){
                        something.visibility = View.INVISIBLE
                        Log.d(TAG, "CRUSH!!")
                    } else
                        Log.d(TAG, "${crash(something, playerView)}")
                })
            }
        }
        moveThread.isDaemon = true

    }


}

