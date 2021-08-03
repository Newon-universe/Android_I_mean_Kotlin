package com.example.thread_practice

import android.widget.ImageView

fun intersect(imageView1: ImageView, imageView2: ImageView) =
    imageView1.left <= imageView2.right &&
            imageView1.right >= imageView2.left &&
            imageView1.top <= imageView2.bottom &&
            imageView1.bottom >= imageView2.top

/*
    !(rect1.left > rect2.right) ||
        rect1.right < rect2.left ||
        rect1.top > rect2.bottom ||
        rect1.bottom < rect2.top
 */