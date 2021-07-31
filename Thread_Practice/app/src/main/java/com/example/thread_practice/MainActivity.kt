package com.example.thread_practice

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.example.thread_practice.databinding.ActivityMainBinding

import kotlin.random.Random as Random

class MainActivity : AppCompatActivity() {


    var handler: Handler = Handler()
    var runnable: Runnable = Runnable {  }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val timer = time(500, 2500).toLong()

        imagemove(binding.imageView1, -400f, 400f, timer)


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
                handler.postDelayed(runnable, duration1)
            }
        }
        handler.post(runnable)
    }



    fun time(from: Int, to: Int) : Int {
        var number = Random
        return number.nextInt(to - from) + from
    }

}