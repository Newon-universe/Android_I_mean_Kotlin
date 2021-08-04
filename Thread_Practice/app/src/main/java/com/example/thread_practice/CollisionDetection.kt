package com.example.thread_practice

import android.animation.ObjectAnimator
import android.util.Log
import android.widget.ImageView
import kotlin.random.Random
import java.lang.Runnable as Runnable1
import java.util.logging.Handler as Handler1

fun crash(image1: ImageView, image2: ImageView):Boolean {
    var check = false;

    if (Math.abs(   (image1.x - image2.x) + ( (image1.width - image2.width) / 2)    )
        < (image2.width + image1.width )/2 &&
        Math.abs(   (image1.y - image2.y) + ( (image1.height - image2.height) / 2)  )
        < (image2.height + image1.height )/2)
        check = true

    return check
}


fun time(from: Int, to: Int) : Int {
    var number = Random
    return number.nextInt(to - from) + from
}


/*
    !(rect1.left > rect2.right) ||
        rect1.right < rect2.left ||
        rect1.top > rect2.bottom ||
        rect1.bottom < rect2.top
 */