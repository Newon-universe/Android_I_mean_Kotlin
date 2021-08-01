package com.example.thread_practice

import android.animation.ObjectAnimator
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ImageView
import com.example.thread_practice.databinding.ActivityMainBinding
import io.github.controlwear.virtual.joystick.android.JoystickView
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

import kotlin.random.Random as Random

class MainActivity : AppCompatActivity() {

    private val TAG = "조이스틱"

    var handler: Handler = Handler()
    var runnable: Runnable = Runnable {  }

    private lateinit var binding: ActivityMainBinding

    private var x: Float = 0.0F
    private var y: Float = 0.0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val timer = time(500, 2500).toLong()

        imagemove(binding.imageView1, -400f, 400f, timer)



        val joystick: JoystickView = binding.joystick
        joystick.setOnMoveListener({ angle: Int, strength: Int ->

            x += (strength * 0.3 * cos((1 - angle.toFloat() / 360) * 2 * PI )).toFloat()
            y += (strength * 0.3 * sin((1 - angle.toFloat() / 360) * 2 * PI )).toFloat()

            Log.d(TAG, "$x, $y")
            imagemove(binding.player, x, y, 25)


        }, 25)

    }


    fun imagemove(image1: ImageView, posix:Float, posiy:Float, duration1: Long){

        runnable = object :Runnable {
            override fun run(){
                ObjectAnimator.ofFloat(image1, "translationX", posix).apply{
                    duration = duration1
                    start()
                }
                ObjectAnimator.ofFloat(image1, "translationY", posiy).apply{
                    duration = duration1
                    start()
                }
//                handler.postDelayed(runnable, duration1)
            }
        }
        handler.post(runnable)
    }


    fun time(from: Int, to: Int) : Int {
        var number = Random
        return number.nextInt(to - from) + from
    }

}