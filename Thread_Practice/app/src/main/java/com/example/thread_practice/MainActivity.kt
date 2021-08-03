package com.example.thread_practice

import android.animation.ObjectAnimator
import android.opengl.Visibility

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
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

    lateinit var selectedView: ImageView





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val timer = time(500, 2500).toLong()
//        imagemove(binding.imageView1, selectedView,-400f, 400f, timer)




        val joystick: JoystickView = binding.joystick
        joystick.setOnMoveListener({ angle: Int, strength: Int ->


            x += (strength * 0.3 * cos((1 - angle.toFloat() / 360) * 2 * PI )).toFloat()
            y += (strength * 0.3 * sin((1 - angle.toFloat() / 360) * 2 * PI )).toFloat()


            joystickMove(binding.player, binding.imageView2, x, y, 25)

        }, 25)

    }

    fun joystickMove(playerView: ImageView, image2: ImageView, posix:Float, posiy:Float, duration1: Long){

        var joystickLoc = IntArray(2)
        var imageLoc = IntArray(2)

        runnable = Runnable {

            image2.getLocationInWindow(imageLoc)

            ObjectAnimator.ofFloat(playerView, "translationX", posix).apply {
                duration = duration1
                playerView.getLocationInWindow(joystickLoc)
                start()
            }
            ObjectAnimator.ofFloat(playerView, "translationY", posiy).apply {
                duration = duration1
                playerView.getLocationInWindow(joystickLoc)
                start()
            }

            if (crash(playerView, image2)){
                image2.visibility = View.INVISIBLE
            } else {
                image2.visibility = View.VISIBLE
            }

            Log.d(TAG, " 조이스틱 좌표 ${joystickLoc[0]}, ${joystickLoc[1]}")
            Log.d(TAG, " 이미지 좌표 ${imageLoc[0]}, ${imageLoc[1]}")
            Log.d(TAG, " ")
            //                handler.postDelayed(runnable, duration1)

        }
        handler.post(runnable)
    }



    fun time(from: Int, to: Int) : Int {
        var number = Random
        return number.nextInt(to - from) + from
    }


    fun crash(image1: ImageView, image2: ImageView):Boolean {
        var check = false;

        if (Math.abs(   (image1.x - image2.x) + ( (image1.width - image2.width) / 2)    )
            < (image2.width + image1.width )/2 &&
            Math.abs(   (image1.y - image2.y) + ( (image1.height - image2.height) / 2)  )
            < (image2.height + image1.height )/2)
            check = true

        return check
    }


}