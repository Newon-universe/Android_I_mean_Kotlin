package com.example.thread_practice

import android.animation.ObjectAnimator
import android.opengl.Visibility

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
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

    private var x: Float = 0.0F
    private var y: Float = 0.0F

    var selectedView: ImageView? = null

    var minute = 1
    var second = 30

    var checker: Int = 90
    var areYouCrush: Boolean = false

//    lateinit var g_playerLoc:IntArray
//    lateinit var g_somethingLoc:IntArray


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var constraintLayout: ConstraintLayout = binding.constraintLayout


//        val timer = time(500, 2500).toLong()
//        imagemove(binding.imageView1, selectedView,-400f, 400f, timer)

        Thread() {
            while (minute >= 0 && second >= 0) {

                second -= 1

                if (second < 0 && minute > 0){
                    second = 59
                    minute -= 1
                } else if (minute == 0 && second == -1)
                    second = 0

                runOnUiThread {
                    binding.minute.text = "0$minute "
                    if(second < 10)
                        binding.second.text = ": 0$second"
                    else
                        binding.second.text = ": $second"
                }

                Thread.sleep(1000L)
            }
        }.start()



        val joystick: JoystickView = binding.joystick
        joystick.setOnMoveListener({ angle: Int, strength: Int ->

            var nextX = (strength * 0.3 * cos((1 - angle.toFloat() / 360) * 2 * PI)).toFloat()
            var nextY = (strength * 0.3 * sin((1 - angle.toFloat() / 360) * 2 * PI)).toFloat()

            // 튀는거 보정
            if (binding.player.x + nextX >= 0 && binding.player.x + nextX <= binding.playGround.x - binding.playGround.width / 2 - 15)
                x += nextX

            if (binding.player.y + nextY >= binding.topMargin.y && binding.player.y + nextY <= binding.playGround.height)
                y += nextY

            joystickMove(binding.player, x, y, nextX, nextY, 25)


//            if (crash(binding.player, binding.something1)){
//                binding.something1.visibility = View.INVISIBLE
//            }
//            if (crash(binding.player, binding.something2)){
//                binding.something2.visibility = View.INVISIBLE
//                runnable = Runnable{
//                    binding.oops.visibility = View.VISIBLE
//                    binding.oops.visibility = View.INVISIBLE
//                }
//                handler.post(runnable)
//            } else {
//                binding.something2.visibility = View.VISIBLE
//            }
//            if (crash(binding.player, binding.something3)){
//                binding.something3.visibility = View.INVISIBLE
//                runnable = Runnable{
//                    binding.oops.visibility = View.VISIBLE
//                    binding.oops.visibility = View.INVISIBLE
//                }
//                handler.post(runnable)
//            } else {
//                binding.something3.visibility = View.VISIBLE
//            }
//            if (crash(binding.player, binding.something4)){
//                binding.something4.visibility = View.INVISIBLE
//                runnable = Runnable{
//                    binding.oops.visibility = View.VISIBLE
//                    binding.oops.visibility = View.INVISIBLE
//                }
//                handler.post(runnable)
//            } else {
//                binding.something4.visibility = View.VISIBLE
//            }

        }, 25)


        Thread(){
            while(checker >= 0){
                Thread.sleep(1000)
                checker--
                if(checker % 4 == 0){
                    handler.post {
                        binding.something1.visibility = View.VISIBLE
                        somethingMove(binding.something1, binding.player, -2000f, 3000)
                        if (binding.something1.x <= 0F){
                            binding.something1.x = 1780F
                        }
                    }
                    Log.d(TAG, "checker : $checker")
                }
            }
        }.start()

    }




    fun joystickMove(playerView: ImageView, posix:Float, posiy:Float, nextX:Float, nextY:Float, duration1: Long) {

        val restrictionX:Float = binding.playGround.x - binding.playGround.width/2 - 14
        val restrictionTopY:Float = binding.topMargin.y
        val restrictionBottomY:Float = binding.playGround.height.toFloat()


        // 이동 예외처리 - 경계선 스턱 보정

        runnable = Runnable {
            if (playerView.x + nextX <= 0)
                playerView.x = 0.toFloat()
            else if (playerView.x + nextX >= restrictionX)
                playerView.x = restrictionX
            else {
                ObjectAnimator.ofFloat(playerView, "translationX", posix).apply {
                    duration = duration1
                    start()
                }
            }
            if (playerView.y + nextY <= restrictionTopY)
                playerView.y = restrictionTopY
            else if (playerView.y + nextY >= restrictionBottomY)
                playerView.y = restrictionBottomY
            else {
                ObjectAnimator.ofFloat(playerView, "translationY", posiy).apply {
                    duration = duration1
                    start()
                }
            }

//            Log.d(TAG, "${playerView.x}")
//            if (crash(playerView, binding.something1))
//                binding.something1.visibility = View.INVISIBLE
        }
        handler.post(runnable)

        //                handler.postDelayed(runnable, duration1)
    }

    fun somethingMove(something: ImageView, playerView:ImageView,posix: Float, duration1: Long){
        runnable = Runnable {
            handler.post {
                ObjectAnimator.ofFloat(something, "translationX", posix).apply {
                    duration = duration1
                    interpolator = LinearInterpolator()
                    start()
                }
            }
        }
        handler.post(runnable)
    }

}

