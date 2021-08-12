package com.example.thread_practice

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import com.airbnb.lottie.LottieAnimationView

class Missile(context: Context) {

    val handler: Handler = Handler()
    val mainThis = context

    fun shooting(time: Int, missile: ImageView, player: LottieAnimationView, speed: Long, oops: View) {
        var shootTime: Int = time
        var canShoot: Boolean = true


        val shooterThread = Thread() {
            while (shootTime >= 0) {
                Thread.sleep(1000)
                shootTime--
                if (shootTime == 0 && canShoot) {
                    canShoot = false
                    handler.post {
                        somethingMove(missile, player, -2000f, speed, oops)
                        if (missile.x <= 0f) {
                            missile.x = 1780F
                            canShoot = true
                        }
                    }
                }
            }
        }
        shooterThread.isDaemon = true
        shooterThread.start()
    }



    fun somethingMove(missile: ImageView, playerView: ImageView, posix: Float, speed: Long, oops:View) {

        var animation: ObjectAnimator

        missile.visibility = View.VISIBLE

        val moveThread = Thread(){
            handler.post{
                animation = ObjectAnimator.ofFloat(missile, "translationX", posix).apply {
                    duration = speed
                    interpolator = LinearInterpolator()
                    start()
                }
                animation.addUpdateListener(ValueAnimator.AnimatorUpdateListener(){
                    if(crash(missile, playerView)){
                        missile.visibility = View.INVISIBLE
                        Log.d("조이스틱", "CRUSH!!")
                    }
                })
            }
        }
        moveThread.isDaemon = true
        moveThread.start()
    }

}