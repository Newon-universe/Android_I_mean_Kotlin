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
import kotlin.math.sin
import kotlin.random.Random as Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding



    private val TAG = "조이스틱"

    var thread: Thread = Thread()
    var handler: Handler = Handler()
    var runnable: Runnable = Runnable {  }
    var start: Boolean = false

    private var x: Float = 0.0F
    private var y: Float = 0.0F

    var selectedView: ImageView? = null

    var minute = 1
    var second = 48

    lateinit var playerLoc: IntArray
    lateinit var somethingLoc: IntArray


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var constraintLayout: ConstraintLayout = binding.constraintLayout


//        val timer = time(500, 2500).toLong()
//        imagemove(binding.imageView1, selectedView,-400f, 400f, timer)

        Thread() {
            while (minute >= 0) {

                second -= 1

                if (second == -1 && minute >= 0)
                    second = 59

                runOnUiThread {
                    binding.minute.text = "0$minute "
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
            if (binding.player.x + nextX >= 0 && binding.player.x + nextX <= binding.playGround.x - binding.playGround.width / 2)
                x += nextX

            if (binding.player.y + nextY >= binding.topMargin.y && binding.player.y + nextY <= binding.playGround.height)
                y += nextY

            joystickMove(binding.player, binding.test, x, y, nextX, nextY, 25)

        }, 25)


        somethingMove(binding.test, binding.player,-1500f, 6000)



    }







    fun joystickMove(playerView: ImageView, image2: ImageView, posix:Float, posiy:Float, nextX:Float, nextY:Float, duration1: Long) {

        // 좌표값 배열
        var joystickLoc = IntArray(2)//        var imageLoc = IntArray(2)

        val restrictionX:Float = binding.playGround.x - binding.playGround.width/2
        val restrictionTopY:Float = binding.topMargin.y
        val restrictionBottomY:Float = binding.playGround.height.toFloat()


        // 이동 예외처리 - 경계선 스턱 보정
        if (playerView.x + nextX <= 0)
            playerView.x = 0.toFloat()
        else if (playerView.x + nextX >= restrictionX)
            playerView.x = restrictionX
        else {
            ObjectAnimator.ofFloat(playerView, "translationX", posix).apply {
                duration = duration1
                playerView.getLocationInWindow(joystickLoc)
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
                playerView.getLocationInWindow(joystickLoc)
                start()
            }
        }

        if (crash(playerView, image2)){
            image2.visibility = View.INVISIBLE
        } else {
            image2.visibility = View.VISIBLE
        }

        Log.d(TAG, " 조이스틱 좌표 ${joystickLoc[0]}, ${joystickLoc[1]}")
//            Log.d(TAG, " 이미지 좌표 ${imageLoc[0]}, ${imageLoc[1]}")
        Log.d(TAG, " ")
        //                handler.postDelayed(runnable, duration1)

    }

    fun somethingMove(something: ImageView, playerView: ImageView, posix: Float, duration1: Long){
        var somethingLoc = IntArray(2)

        ObjectAnimator.ofFloat(something, "translationX", posix).apply{
            duration = duration1
            interpolator = LinearInterpolator()
            something.getLocationInWindow(somethingLoc)
            start()
        }
    }

}

